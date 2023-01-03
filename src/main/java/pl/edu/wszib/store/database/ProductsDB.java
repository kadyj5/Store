package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDB {
    private final List<Product> products = new ArrayList<>();
    private static final ProductsDB instance = new ProductsDB();

    public ProductsDB() {
        this.products.add(new Product("Iphone 14 pro", 7, 6499.00, 1));
        this.products.add(new Product("Ładowarka samochodowa", 2, 59.99, 2));
        this.products.add(new Product("Kabel do ladowania Apple", 1, 100.00, 3));
        this.products.add(new Product("Szklo hartowane", 3, 150.0, 4));

    }

    public String buyProduct(int productID, int quantity){
        for(Product product : this.products){
            if(product.getProductID() == productID &&
                    (product.getQuantity() - quantity) >= 0){
                product.setQuantity(product.getQuantity() - quantity);
                return String.valueOf((quantity * product.getUnitPrice()));
            }
        }
        return null;
    }

    public boolean changeQuantity(int productID, int addAmount){
        for (Product product: this.products) {
            if(productID == product.getProductID() &&
                    (product.getQuantity() + addAmount >=0)){
                product.setQuantity(product.getQuantity() + addAmount);
                return true;
            }
        }
        return false;
    }

    public static ProductsDB getInstance() {
        return instance;
    }

    public List<Product> getProducts(){
        return products;
    }
}
