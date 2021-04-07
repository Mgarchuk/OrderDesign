package by.student.orderDesign.storage;

import by.student.orderDesign.domain.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderItemStorageTest {

    private OrderItemStorage orderItemStorage;

    @BeforeEach
    public void before() {
        orderItemStorage = new OrderItemStorage();
    }

    @Test
    void addOrderItemTest() {
        OrderItem orderItem = new OrderItem("i007", "Milk", 1, 1.56, 1_612_472_400_000L,
                1_613_336_400_000L, 0);
        orderItemStorage.addOrderItem(orderItem);
        assertEquals(orderItemStorage.getOrderItem("i007"), orderItem);
        assertEquals(orderItemStorage.getOrderItemsCount(), 1);
    }

    @Test
    void editOrderItemTest() {
        OrderItem orderItem = new OrderItem("i007", "Milk", 1, 1.56, 1_612_472_400_000L,
                1_613_336_400_000L, 0);
        orderItemStorage.addOrderItem(orderItem);
        OrderItem changedOrderItem = new OrderItem("i088", "Bread", 1, 1.05, 1_612_990_800_000L,
                1_613_336_400_000L, 0);
        orderItemStorage.editOrderItem("i007", changedOrderItem);
        assertEquals(orderItemStorage.getOrderItem("i007").getName(), "Bread");
        assertEquals(orderItemStorage.getOrderItem("i007").getPrice(), 1.05);
    }

    @Test
    void deleteOrderItemTest() {
        OrderItem orderItem = new OrderItem("i007", "Milk", 1, 1.56, 1_612_472_400_000L,
                1_613_336_400_000L, 0);
        orderItemStorage.addOrderItem(orderItem);
        orderItemStorage.deleteOrderItem("i007");
        assertEquals(orderItemStorage.getOrderItemsCount(), 0);
    }

    @Test
    void getOrderItemTest() {
        OrderItem orderItem = new OrderItem("i007", "Milk", 1, 1.56, 1_612_472_400_000L,
                1_613_336_400_000L, 0);
        orderItemStorage.addOrderItem(orderItem);
        assertEquals(orderItemStorage.getOrderItem("i007"), orderItem);
    }

    @Test
    void getOrderItemsCountTest() {
        OrderItem orderItem_1 = new OrderItem("i007", "Milk", 1, 1.56, 1_612_472_400_000L,
                1_613_336_400_000L, 0);
        OrderItem orderItem_2 = new OrderItem("i088", "Bread", 1, 1.05, 1_612_990_800_000L,
                1_613_336_400_000L, 0);
        OrderItem orderItem_3 = new OrderItem("i088", "Bread", 1, 1.05, 1_612_990_800_000L,
                1_613_336_400_000L, 0);
        orderItemStorage.addOrderItem(orderItem_1);
        orderItemStorage.addOrderItem(orderItem_2);
        orderItemStorage.addOrderItem(orderItem_3);

        assertEquals(orderItemStorage.getOrderItemsCount(), 3);
    }
}