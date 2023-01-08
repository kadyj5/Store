package pl.edu.wszib.store.entity;

public final class Electronic extends Product{
    private final String dateOfrelease;

    public Electronic(String productName, String brand, int quantity, double unitPrice, int productID, String yearOfRelease) {
        super(productName, brand,quantity, unitPrice, productID);
        this.dateOfrelease = yearOfRelease;
    }
    public String getDateOfrelease() {
        return dateOfrelease;
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("\tDate of release: ")
                .append(this.getDateOfrelease());
    }
}
