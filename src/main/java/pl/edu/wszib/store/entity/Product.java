package pl.edu.wszib.store.entity;

public sealed class Product permits Electronic, Foodstuff {
    private final String productName;
    private final String brand;
    private int quantity;
    private final double unitPrice;
    private final int productID;

    public Product(String productName, String brand, int quantity, double unitPrice, int productID) {
        this.productName = productName;
        this.brand = brand;
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

    public String getBrand() { return  brand; }


    @Override
    public String toString() {
        return new StringBuilder()
                .append("Product ID: ")
                .append(this.getProductID())
                .append("\t")
                .append(this.getProductName())
                .append(" ")
                .append(this.getBrand())
                .append("\tCena: ")
                .append(this.getUnitPrice())
                .append(" Ilosc: ")
                .append(this.getQuantity())
                .toString();
    }
}

