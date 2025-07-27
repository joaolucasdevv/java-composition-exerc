package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDate moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

}
