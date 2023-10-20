package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Customer para definir un cliente con nombre, apellidos y dirección.
 *
 * @version 1.4
 */
public class Customer {

    /* Atributos */
    private String name;
    private String surname;

    private Address address;

    private List<Order> orderList;

    /**
     * Constructor de Customer.
     *
     * @param name String que representa el nombre.
     * @param surname String que representa el apellido.
     * @param street String que representa la calle.
     * @param number int que representa el número de la calle.
     * @param postalCode int que representa el código postal.
     * @param city String que representa el nombre de la ciudad.
     */
    public Customer(String name, String surname, String street, int number, int postalCode, String city) {
        this.name = name;
        this.surname = surname;
        this.address = new Address(street, number, postalCode, city);
        this.orderList = new ArrayList<>();
    }

    /* Métodos */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(String street, int number, int postalCode, String city) {
        this.address.setStreet(street);
        this.address.setNumber(number);
        this.address.setPostalCode(postalCode);
        this.address.setCity(city);
    }

    public void addOrder(Restaurant restaurant, List<Dish> dishList, List<Integer> quantity) {
        Order newOrder = new Order(this, restaurant);
        int length = dishList.size();
        for (int index = 0; index < length; index++) {
            OrderItem newOrderItem = new OrderItem(dishList.get(index), quantity.get(index));
            newOrder.addOrder(newOrderItem);
        }
        this.orderList.add(newOrder);
    }

    public Order getOrder(int index) {
        return this.orderList.get(index);
    }

    public void removeOrder(int index) {
        if (!(index >= this.orderList.size()) && (index >= 0)) {
            this.orderList.remove(index);
        }
    }

    // Método equals() para que el método .contains() funcione correctamente.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && address.equals(customer.address);
    }
}
