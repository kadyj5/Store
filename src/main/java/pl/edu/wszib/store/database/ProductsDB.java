package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ProductsDB {
    private final List<Product> products = new ArrayList<>();
    private static final ProductsDB instance = new ProductsDB();

    public ProductsDB() {
        this.products.add(new Product("Iphone 14 pro", 7, 6499.00, 1));
        this.products.add(new Product("Ładowarka samochodowa", 2, 59.99, 2));
        this.products.add(new Product("Kabel do ladowania Apple", 1, 100.00, 3));
        this.products.add(new Product("Szklo hartowane", 3, 150.0, 4));

    }

    public int buyProduct(int productID, int quantity) {
        Stream<Product> productStream = this.products.stream();
        Optional<Product> productOptional = productStream.filter(product -> product.getProductID() == productID)
                .filter(product -> product.getQuantity() - quantity >= 0)
                .findFirst();
        if(productOptional.isPresent()){
            changeQuantity(productID, -quantity);
            return (int) (quantity * productOptional.get().getUnitPrice());
        }
        return 0;
    }

    public boolean changeQuantity(int productID, int addAmount) {
        Stream<Product> productStream = this.products.stream();
        Optional<Product> productOptional = productStream.filter(product -> product.getProductID() == productID)
                .filter(product -> product.getQuantity() + addAmount >= 0)
                .findFirst();
        if (productOptional.isEmpty()) return false;
        else {
            Product product = this.products.get(this.products.indexOf(productOptional.get()));
            product.setQuantity((product.getQuantity() + addAmount));
            return true;
        }
    }

    public static ProductsDB getInstance() {
        return instance;
    }

    public List<Product> getProducts(){
        return products;
    }
}
