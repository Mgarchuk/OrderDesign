package by.student.orderDesign.service;

import by.student.orderDesign.domain.Order;
import by.student.orderDesign.domain.OrderItem;
import by.student.orderDesign.domain.OrderStatus;
import by.student.orderDesign.storage.OrderItemStorage;
import by.student.orderDesign.storage.OrderStorage;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

public class OrderService {

    private final OrderStorage storage;
    private final OrderItemStorage itemStorage;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class.getName());

    public OrderService(OrderStorage orderStorage, OrderItemStorage orderItemStorage) {
        this.storage = orderStorage;
        this.itemStorage = orderItemStorage;

    }

    public String placeOrder(Order order) throws NullPointerException {
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
        for(OrderItem item : order.getItems()) {
            itemStorage.addOrderItem(item);
        }

        logger.info("Order with orderId: {} placed", order.getId());

        return order.getId();
    }

    public List<Order> loadAllByUserId(String userId) {
        Preconditions.checkNotNull(userId, "Null user id");
        List<Order> userOrders = storage.getOrdersByUserId(userId);

        logger.info("Orders for user with id: {} was loaded. Orders count: {}", userId, userOrders.size());
        return userOrders;
    }
}
