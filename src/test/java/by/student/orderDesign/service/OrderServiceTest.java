package by.student.orderDesign.service;

import by.student.orderDesign.domain.Address;
import by.student.orderDesign.domain.Order;
import by.student.orderDesign.domain.OrderStatus;
import by.student.orderDesign.storage.OrderItemStorage;
import by.student.orderDesign.storage.OrderStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OrderServiceTest {
    private OrderService service;
    private OrderStorage orderStorage;
    private OrderItemStorage orderItemStorage;

    @BeforeEach
    public void before() {
        orderStorage = mock(OrderStorage.class);
        orderItemStorage = mock(OrderItemStorage.class);
        service = new OrderService(orderStorage, orderItemStorage);
    }

    @Test
    void placeOrderTest() {
        final Order orderWithNullField = new Order("1", "u1", new Date(), null);
        assertThrows(NullPointerException.class, () -> service.placeOrder(orderWithNullField));

        final Order correctOrder = new Order("1", "u1", new Date(), new Address("a", "b", "c", "d", "e"));
        assertEquals(correctOrder.getStatus(), OrderStatus.IN_VALIDATION);
        service.placeOrder(correctOrder);
        assertEquals(correctOrder.getStatus(), OrderStatus.ACCEPTED);

        final String id = service.placeOrder(correctOrder);
        assertNotNull(id);
    }

    @Test
    void loadAllByUserIdTest() {
        assertThrows(NullPointerException.class, () -> service.loadAllByUserId(null));
    }
}