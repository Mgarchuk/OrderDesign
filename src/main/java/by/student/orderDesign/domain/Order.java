package by.student.orderDesign.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final String id;
    private final String userId;
    private final List<OrderItem> items = new ArrayList<>();
    private double totalPrice = 0;
    private OrderStatus status = OrderStatus.IN_VALIDATION;
    private Date expectedDeliveryDate;
    private Address address;
    private PaymentMethod paymentMethod;

    public Order(String id, String userId, Date expectedDeliveryDate, Address address, PaymentMethod paymentMethod) {
        this.id = id;
        this.userId = userId;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public Order(String id, String userId, long expectedDeliveryDateMs, Address address, PaymentMethod paymentMethod) {
        this(id, userId, new Date(expectedDeliveryDateMs), address, paymentMethod);
    }

    public Order(String id, String userId, Date expectedDeliveryDate, Address address) {
        this(id, userId, expectedDeliveryDate, address, PaymentMethod.CASH);
    }

    public Order(String id, String userId, long expectedDeliveryDateMs, Address address) {
        this(id, userId, new Date(expectedDeliveryDateMs), address, PaymentMethod.CASH);
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public long getExpectedDeliveryDateMs() {
        return expectedDeliveryDate.getTime();
    }

    public Address getAddress() {
        return address;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setExpectedDeliveryDate(long expectedDeliveryDateMs) {
        this.expectedDeliveryDate.setTime(expectedDeliveryDateMs);
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addItem(String itemId, String name, int quantity, double price, long dateOfManufactureMs, long expirationDateMs, long guarantyMs) {
        items.add(new OrderItem(itemId, name, quantity, price, dateOfManufactureMs, expirationDateMs, guarantyMs));
        totalPrice += price;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }
}
