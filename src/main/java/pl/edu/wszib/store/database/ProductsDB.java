package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.Product;

public class ProductsDB {
    private Product[] products = new Product[4];
    private static final ProductsDB instance = new ProductsDB();

    public ProductsDB() {
        this.products[0] = new Product("Iphone 14 pro", 7, "6499.00 zl", 1);
        this.products[1] = new Product("Ładowarka samochodowa", 2, "59.99 zl", 2);
        this.products[2] = new Product("Kabel do ladowania Apple", 1, "100.00 zl", 3);
        this.products[3] = new Product("Szklo hartowane", 3, "150.0 zl", 4);

    }

    public static ProductsDB getInstance() {
        return instance;
    }

    public Product[] getProducts(){
        return products;
    }
}
