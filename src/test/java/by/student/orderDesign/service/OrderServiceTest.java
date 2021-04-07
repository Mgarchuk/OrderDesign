package by.student.orderDesign.service;

import by.student.orderDesign.domain.Address;
import by.student.orderDesign.domain.Order;
import by.student.orderDesign.storage.OrderStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceTest {
    OrderService service;

    @BeforeEach
    public void before() {
        service = new OrderService(new OrderStorage());
    }

    @Test
    void placeOrderTest() {
        Order order = new Order("1", "u1", new Date(), null);
        boolean findNullException = false;
        try {
            service.placeOrder(order);
        } catch (NullPointerException e) {
            findNullException = true;
        } catch (UnsupportedOperationException ignored) {

        } finally {
            assertTrue(findNullException);
        }

        order = new Order("1", "u1", new Date(), new Address("Belarus", "Minsk", "Soviet", "Lenina", 25));

        findNullException = false;
        try {
            service.placeOrder(order);
        } catch (NullPointerException e) {
            findNullException = true;
        } catch (UnsupportedOperationException ignored) {

        } finally {
            assertFalse(findNullException);
        }

    }

    @Test
    void loadAllByUserIdTest() {
        boolean findNullException = false;

        try {
            service.loadAllByUserId(null);
        } catch (NullPointerException e) {
            findNullException = true;
        } catch (UnsupportedOperationException ignored) {

        } finally {
            assertTrue(findNullException);
        }

        findNullException = false;

        try {
            service.loadAllByUserId("4");
        } catch (NullPointerException e) {
            findNullException = true;
        } catch (UnsupportedOperationException ignored) {

        } finally {
            assertFalse(findNullException);
        }
    }
}