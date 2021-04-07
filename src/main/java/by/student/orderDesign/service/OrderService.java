package by.student.orderDesign.service;

import by.student.orderDesign.domain.Address;
import by.student.orderDesign.domain.Order;
import by.student.orderDesign.domain.OrderStatus;
import by.student.orderDesign.storage.OrderStorage;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderService {

    private final OrderStorage storage;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class.getName());

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

        logger.info("Order with id: {} was successfully checked for null fields", order.getId());

        order.setStatus(OrderStatus.ACCEPTED);

        storage.addOrder(order);

        logger.info("Order with orderId: {} placed", order.getId());
    }

    public List<Order> loadAllByUserId(String userId) {
        Preconditions.checkNotNull(userId, "Null user id");
        List<Order> userOrders = storage.getOrdersByUserId(userId);

        logger.info("Orders for user with id: {} was loaded. Orders count: {}", userId, userOrders.size());
        return userOrders;
    }
}
