package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase organizadora de métodos que administra los pedidos de los clientes.
 * @version 1.1
 */
public class OrderManager {

    /* Atributos */
    private List<Customer> customerList;
    private List<Restaurant> restaurantList;
    private List<Dish> dishList;

    /* Constructor */
    public OrderManager() {
        this.restaurantList = new ArrayList<Restaurant>();
        this.customerList = new ArrayList<Customer>();
        this.dishList = new ArrayList<Dish>();
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

    public void addRestaurant(String name, String input_phone, String menuName, MenuType menuType) {
        Restaurant newRestaurant = new Restaurant(name, input_phone, menuName, menuType);
        this.restaurantList.add(newRestaurant);
    }

    public Customer getCustomer(int i) {
        if (!(i >= this.customerList.size())) {
            return this.customerList.get(i);
        }
    }

    public Restaurant getRestaurant(int i) {
        if (!(i >= this.restaurantList.size())) {
            return this.restaurantList.get(i);
        }
    }

    public Dish getDish(int i) {
        if (!(i >= this.dishList.size())) {
            return this.dishList.get(i);
        }
    }


    public void order(Customer customer, Restaurant restaurant, List<Integer> dishesId, List<Integer> quantity) {
        int length = dishesId.size();
        List<Dish> dishOrder = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            dishOrder.add(dishList.get(dishesId.get(index)));
        }
        customer.addOrder(restaurant, dishOrder, quantity);
    }

    public void deleteCustomer(int i) {
        if (!(i >= this.customerList.size())) {
            this.customerList.remove(i);
        }
    }

    public void deleteRestaurant(int i) {
        if (!(i >= this.restaurantList.size())) {
            this.restaurantList.remove(i);
        }
    }

    public void deleteDish(int i) {
        if (!(i >= this.dishList.size())) {
            this.dishList.remove(i);
        }
    }

    public int numberOfCustomers() {
        return this.customerList.size();
    }
}
