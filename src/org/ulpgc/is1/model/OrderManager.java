package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase organizadora de métodos que administra los pedidos de los clientes.
 * @version 1.5
 */
public class OrderManager {

    /* Atributos */
    private List<Customer> customerList;
    private List<Restaurant> restaurantList;
    private List<Dish> dishList;

    /* Constructor */
    public OrderManager() {
        this.restaurantList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    /* Métodos */

    public void addCustomer(String name, String surname, String address, int number, int postalCode, String city) {
        Customer newCustomer = new Customer(name, surname, address, number, postalCode, city);
        if (!customerList.contains(newCustomer)){
            this.customerList.add(newCustomer);
        }
    }
    public void addDish(String name, String description, int price) {
        Dish newDish = new Dish(name, description, price);
        if (!dishList.contains(newDish)){
            this.dishList.add(newDish);
        }
    }
    public void addRestaurant(String name, String input_phone, String menuName, MenuType menuType) {
        Restaurant newRestaurant = new Restaurant(name, input_phone, menuName, menuType);
        if (!restaurantList.contains(newRestaurant)){
            this.restaurantList.add(newRestaurant);
        }
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

    public void deleteCustomer(int i) {
        if (!(i >= this.customerList.size()) && (i >= 0)) {
            this.customerList.remove(i);
        }
    }
    public void deleteRestaurant(int i) {
        if (!(i >= this.restaurantList.size()) && (i >= 0)) {
            this.restaurantList.remove(i);
        }
    }
    public void deleteDish(int i) {
        if (!(i >= this.dishList.size()) && (i >= 0)) {
            this.dishList.remove(i);
        }
    }

    public int numberOfCustomers() {
        return this.customerList.size();
    }

    public void order(Customer customer, Restaurant restaurant, List<Integer> dishesId, List<Integer> quantity) {
        List<Dish> dishOrder = new ArrayList<>();
        for (Integer integer : dishesId) {
            dishOrder.add(dishList.get(integer));
        }
        customer.addOrder(restaurant, dishOrder, quantity);
    }
}
