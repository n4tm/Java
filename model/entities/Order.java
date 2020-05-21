package curso.orders.model.entities;
import curso.orders.model.enums.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> itens = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void addItem(OrderItem item) {
        itens.add(item);
    }

    public void removeItem(OrderItem item) {
        itens.remove(item);
    }
    
    public List<OrderItem> getItens() {
        return itens;
    }

    public double total() {
        double total = 0.0;
            for (OrderItem iteml : itens) {
                total += iteml.subTotal();
            }
        return total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        sb.append("\u001B[1m" + "ORDER SUMMARY:\n");
        sb.append("Order moment: ");
        sb.append(sdf1.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status.toString().substring(0, 1) + status.toString().substring(1).toLowerCase() + "\n");
        sb.append(client.toString());
        sb.append("Order itens:\n");
        for(OrderItem itensEl : itens){
            sb.append(itensEl.toString());
        }
        sb.append("Total price: " + total());
        return sb.toString();
    }
}