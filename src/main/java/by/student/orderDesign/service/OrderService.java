package by.student.orderDesign.service;

import by.student.orderDesign.domain.Order;
import by.student.orderDesign.domain.OrderStatus;
import by.student.orderDesign.storage.OrderStorage;
import com.google.common.base.Preconditions;

import java.util.List;

public class OrderService {

    private final OrderStorage storage;

    public OrderService(OrderStorage orderStorage) {
        this.storage = orderStorage;
    }

    public void placeOrder(Order order) throws NullPointerException {
        Preconditions.checkNotNull(order, "Null order");
        Preconditions.checkNotNull(order.getAddress(), "Null address");
        Preconditions.checkNotNull(order.getId(), "Null id");
        Preconditions.checkNotNull(order.getUserId(), "Null userId");
        Preconditions.checkNotNull(order.getPaymentMethod(), "Null payment method");
        Preconditions.checkNotNull(order.getItems(), "Null items");
        Preconditions.checkNotNull(order.getExpectedDeliveryDate(), "Null date");
        Preconditions.checkNotNull(order.getStatus(), "Null status");

        order.setStatus(OrderStatus.ACCEPTED);

        storage.addOrder(order);
    }

    public List<Order> loadAllByUserId(String userId) {
        Preconditions.checkNotNull(userId, "Null user id");
        return storage.getOrdersByUserId(userId);
    }
}
