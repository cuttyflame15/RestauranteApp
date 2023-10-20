package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Order para representar las peticiones de los clientes, conteniendo al cliente
 * y al restaurante al que se realiza la petición.
 *
 * @version 1.0
 */
public class Order {

    /* Atributos */
    private static int NEXT_ID = 1;
    private final int id;
    private List<OrderItem> orderItemList;
    private Restaurant restaurant;
    private Customer customer;

    /**
     * Constructor de clase Order.
     *
     * @param customer Objeto de la clase Customer que represente al cliente.
     * @param restaurant Objeto de la clase Restaurant que represente el restaurante.
     */
    public Order(Customer customer, Restaurant restaurant) {
        this.id = NEXT_ID++;
        this.orderItemList = new ArrayList<OrderItem>();
        this.customer = customer;
        this.restaurant = restaurant;
        this.restaurant.addOrder(this);
    }

    /* Métodos */
    public void addOrder(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public int price() {
        int price = 0;
        for (OrderItem items: orderItemList) {
            price += items.getDish().getPrice();
        }
        return price;
    }

    public OrderItem getOrderItem(int index) {
        if (!(index >= this.orderItemList.size())) {
            return this.orderItemList.get(index);
        }
    }

    public void removeOrderItem(int index) {
        if (!(index >= this.orderItemList.size())) {
            this.orderItemList.remove(index);
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItemList.add(orderItem);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    // Método equals para que la lista funcione correctamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }
}
