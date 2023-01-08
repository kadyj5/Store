package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.Electronic;
import pl.edu.wszib.store.entity.Foodstuff;
import pl.edu.wszib.store.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ProductsDB {
    private final List<Product> products = new ArrayList<>();
    private static final ProductsDB instance = new ProductsDB();

    public ProductsDB() {
        this.products.add(new Electronic("Iphone 14 pro", "Apple", 7, 6499.00, 1, "September 16, 2022"));
        this.products.add(new Electronic("Ładowarka samochodowa","Motorola", 2, 59.99, 2,  "October 20, 2016"));
        this.products.add(new Electronic("Kabel do ladowania lightning","Apple", 1, 100.00, 3,  "September 12, 2012"));
        this.products.add(new Foodstuff("Przyprawa do pieczenia","Kamis", 25, 2.15, 4,  "15-12-2028", 42));
        this.products.add(new Foodstuff("Ketchup 500ml","Heinz", 14, 6.99, 5,  "21-11-2024", 1));

    }

    public double buyProduct(int productID, int quantity) {
        Stream<Product> productStream = this.products.stream();
        Optional<Product> productOptional = productStream.filter(product -> product.getProductID() == productID)
                .filter(product -> product.getQuantity() - quantity >= 0)
                .findFirst();
        if(productOptional.isPresent()){
            changeQuantity(productID, -quantity);
            return (double) (quantity * productOptional.get().getUnitPrice());
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
