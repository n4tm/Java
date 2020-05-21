package curso.orders.model.enums;

public enum OrderStatus {
    PENDING_PAYMENT(0), PROCESSING(1), SHIPPED(2), DELIVERED(3);
    
    OrderStatus(int status){
    }
}