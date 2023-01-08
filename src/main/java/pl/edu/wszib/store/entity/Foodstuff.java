package pl.edu.wszib.store.entity;

public final class Foodstuff extends Product{
    private final String bestBeforeDate;
    private final int quantityInUnit;

    public Foodstuff(String productName, String brand,int quantity, double unitPrice, int productID, String bestBeforeDate, int quantityInUnit) {
        super(productName,brand, quantity, unitPrice, productID);
        this.bestBeforeDate = bestBeforeDate;
        this.quantityInUnit = quantityInUnit;
    }
    public int getQuantityInUnit() {
        return quantityInUnit;
    }

    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("\tSztuk w opakowaniu: ")
                .append(this.getQuantityInUnit())
                .append(" Data waznosci: ")
                .append(this.getBestBeforeDate());
    }
}
