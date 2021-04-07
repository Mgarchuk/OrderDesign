package by.student.orderDesign.domain;

import java.util.Date;

public class OrderItem {

    private final String id;
    private final String name;
    private int quantity;
    private double price;
    private final long dateOfManufactureMs;
    private final long expirationDateMs;
    private long guaranteeMs;
    private static final long THIRTY_DAYS = 2_592_000_000L;

    public OrderItem(String id, String name, int quantity, double price, long dateOfManufactureMs, long expirationDateMs, long guaranteeMs) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.dateOfManufactureMs = dateOfManufactureMs;
        this.expirationDateMs = expirationDateMs;
        this.guaranteeMs = guaranteeMs;
    }

    public OrderItem(String id, String name, int quantity, double price, Date dateOfManufacture, Date expirationDate, long guaranteeMs) {
        this(id, name, quantity, price, dateOfManufacture.getTime(), expirationDate.getTime(), guaranteeMs);
    }

    public OrderItem(String id, String name, int quantity, double price, long dateOfManufactureMs, long expirationDateMs) {
        this(id, name, quantity, price, dateOfManufactureMs, expirationDateMs, THIRTY_DAYS);
    }

    public OrderItem(String id, String name, int quantity, double price, Date dateOfManufacture, Date expirationDate) {
        this(id, name, quantity, price, dateOfManufacture.getTime(), expirationDate.getTime(), THIRTY_DAYS);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public long getDateOfManufactureMs() {
        return dateOfManufactureMs;
    }

    public long getExpirationDateMs() {
        return expirationDateMs;
    }

    public long getGuaranteeMs() {
        return guaranteeMs;
    }

    public Date getDateOfManufacture() {
        return new Date(dateOfManufactureMs);
    }

    public Date getExpirationDate() {
        return new Date(expirationDateMs);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGuaranteeMs(long guaranteeMs) {
        this.guaranteeMs = guaranteeMs;
    }
}
