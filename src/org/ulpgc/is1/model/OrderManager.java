package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase organizadora de métodos que administra los pedidos de los clientes.
 * @version 1.0
 * RESTRICCIONES en cada clase?
 */
public class OrderManager {

    /* Atributos */
    private List<Customer> customerList;
    private List<Restaurant> restaurantList;
    private List<Dish> dishList;

    /* Constructor */
    public OrderManager() {
        this.restaurantList = new ArrayList();
        this.customerList = new ArrayList();
        this.dishList = new ArrayList();
    }

    /* Métodos */

    public void addCustomer(String name, String surname, String address, int number, int postalCode, String city) {
        Customer newCustomer = new Customer(name, surname, address, number, postalCode, city);
        this.customerList.add(newCustomer);
    }

    public void addDish(String name, String description, int price) {
        Dish newDish = new Dish(name, description, price);
        this.dishList.add(newDish);
    }

    public void addRestaurant(String name, Phone number) {
        Restaurant newRestaurant = new Restaurant(name, number);
        this.restaurantList.add(newRestaurant);
    }

    public Customer getCustomer(int i) {
        return this.customerList.get(i);
    }

    public Restaurant getRestaurant(int i) {
        return this.restaurantList.get(i);
    }

    public Dish getDish(int i) {
        return this.dishList.get(i);
    }


    public void order(Customer customer, Restaurant restaurant, List<Integer> dishesId, List<Integer> quantity) {
        Order newOrder = new Order(customer, restaurant);
        int length = dishesId.size();
        for (int index = 0; index < length; index++) {
            OrderItem newOrderItem = new OrderItem(dishList.get(dishesId.get(index)), quantity.get(index));
            newOrder.addOrder(newOrderItem);
        }
    }

    public void deleteCustomer(int i) {
        this.customerList.remove(i);
    }

    public void deleteRestaurant(int i) {
        this.restaurantList.remove(i);
    }

    public void deleteDish(int i) {
        this.dishList.remove(i);
    }

    public int numberOfCustomers() {
        return this.customerList.size();
    }
}
