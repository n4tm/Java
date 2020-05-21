package curso.orders.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import curso.orders.model.entities.Client;
import curso.orders.model.entities.Order;
import curso.orders.model.entities.OrderItem;
import curso.orders.model.entities.Product;
import curso.orders.model.enums.OrderStatus;

public class Main {
    public static void main(String args[]) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();

        System.out.print("\u001B[1m" + "Enter cliente data:\n");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date date = (Date) sdf.parse(sc.nextLine());

        Client client = new Client(name, email, date);

        System.out.print("\u001B[1m" + "Enter order data:\n");
        System.out.print("Status: ");
        String statusString = sc.next();
        System.out.print("How many itens to this order? ");
        int numItens = sc.nextInt();
        sc.nextLine();
        Product prod1 = new Product();
        OrderItem item = new OrderItem();
        List<OrderItem> itens = new ArrayList<>();
        OrderStatus status = OrderStatus.valueOf(statusString);
        Order order = new Order(today, status, client);
        for (int i = 0; i < numItens; i++) {
            System.out.printf("\u001B[1m" + "Enter #%d item data:\n", i + 1);
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            prod1 = new Product(productName, price);
            item = new OrderItem(quantity, price, prod1);
            itens.add(item);
            order.addItem(item);
        }

        System.out.println(order);
        sc.close();
    }
}