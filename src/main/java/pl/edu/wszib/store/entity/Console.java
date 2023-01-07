package pl.edu.wszib.store.entity;

public final class Console extends Product{
    private final String mark;
    private final int yearOfRelease;

    public Console(String productName, int quantity, double unitPrice, int productID, String mark, int yearOfRelease) {
        super(productName, quantity, unitPrice, productID);
        this.mark = mark;
        this.yearOfRelease = yearOfRelease;
    }
}
