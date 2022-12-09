package pl.edu.wszib.store.entity;

public class Product {
    private  String productName;
    private int quantity;
    private  double unitPrice;
    private final int productID;

    public Product(String productName, int quantity, double unitPrice, int productID) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Product ID: ")
                .append(this.getProductID())
                .append("\t")
                .append(this.getProductName())
                .append(" Cena: ")
                .append(this.getUnitPrice())
                .append(" Ilosc: ")
                .append(this.getQuantity())
                .toString();
    }
}

