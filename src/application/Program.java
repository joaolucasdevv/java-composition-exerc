package application;

import entities.Client;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate bithDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.println("Enter order data:");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());

        Order order = new Order(LocalDate.now(), orderStatus, new Client(name, email, bithDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String productName = sc.nextLine();
        }








        sc.close();
    }

}
