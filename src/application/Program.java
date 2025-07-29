package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate bithDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());

        Order order = new Order(LocalDateTime.now(), orderStatus, new Client(name, email, bithDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextInt();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(productName, productPrice));

            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY:");

        System.out.println("Order moment: " + order.getMoment().format(fmt));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client " + order.getClient());


        sc.close();
    }

}
