package DesignPatterns.Creational.Builder;

import lombok.ToString;

/**
 * Classic Builder with static inner class
 */
@ToString
public class Order {
    private int id;
    private String customerName;

    private Order(){}

    public static OrderBuilder Builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder{
        int id;
        String customerName;

        public OrderBuilder ID(int id){
            this.id = id;
            return this;
        }

        public OrderBuilder CustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }

        public Order build(){
            Order order = new Order();
            order.customerName = this.customerName;
            order.id = this.id;
            return order;
        }
    }
}
