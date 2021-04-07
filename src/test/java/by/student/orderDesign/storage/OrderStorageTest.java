package by.student.orderDesign.storage;

import by.student.orderDesign.domain.Address;
import by.student.orderDesign.domain.Order;
import by.student.orderDesign.domain.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OrderStorageTest {

    private OrderStorage orderStorage;
    private final Address address = new Address("Belarus", "Brest", "Leninist", "Alaya", 5);
    private final Date expectedDeliveryDate = new Date(System.currentTimeMillis() + 172_800_000);

    @BeforeEach
    public void before() {
        orderStorage = new OrderStorage();
    }

    @Test
    void addOrderTest() {
        Order order = new Order("1", "u1", expectedDeliveryDate, address);
        assertEquals(orderStorage.getOrdersCount(), 1);
        assertEquals(orderStorage.getOrder("1"), order);
    }

    @Test
    void editOrderTest() {
        Order order = new Order("1", "u1", expectedDeliveryDate, address);
        orderStorage.addOrder(order);
        Order changedOrder = new Order("2", "u1", expectedDeliveryDate, address, PaymentMethod.ONLINE);
        orderStorage.editOrder("1", changedOrder);

        assertNotEquals(orderStorage.getOrder("1").getPaymentMethod(), PaymentMethod.CASH);
    }

    @Test
    void deleteOrderTest() {
        Order order = new Order("1", "u1", expectedDeliveryDate, address);
        orderStorage.addOrder(order);
        orderStorage.deleteOrder("1");
        assertEquals(orderStorage.getOrdersCount(), 1);
    }

    @Test
    void getOrderTest() {
        Order order = new Order("1", "u1", expectedDeliveryDate, address);
        orderStorage.addOrder(order);
        assertEquals(orderStorage.getOrder("1"), order);
    }

    @Test
    void getOrdersCountTest() {
        Order order_1 = new Order("1", "u1", expectedDeliveryDate, address);
        Order order_2 = new Order("2", "u2", expectedDeliveryDate, address, PaymentMethod.CARD);
        orderStorage.addOrder(order_1);
        orderStorage.addOrder(order_2);
        assertEquals(orderStorage.getOrdersCount(), 2);
    }

    @Test
    void getOrdersByUserIdTest() {
        Order order_1 = new Order("1", "u1", expectedDeliveryDate, address);
        Order order_2 = new Order("2", "u2", expectedDeliveryDate, address, PaymentMethod.CARD);
        Order order_3 = new Order("3", "u1", expectedDeliveryDate, address, PaymentMethod.CARD);
        Order order_4 = new Order("4", "u1", expectedDeliveryDate, address, PaymentMethod.ONLINE);
        orderStorage.addOrder(order_1);
        orderStorage.addOrder(order_2);
        orderStorage.addOrder(order_3);
        orderStorage.addOrder(order_4);
        assertEquals(orderStorage.getOrdersByUserId("u1").get(0), order_1);
        assertEquals(orderStorage.getOrdersByUserId("u1").get(1), order_3);
        assertEquals(orderStorage.getOrdersByUserId("u1").get(2), order_4);
    }
}