package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;

    private Address address;

    private List<Order> orderList;

    public Customer(String name, String surname, String address, int number, int postalCode, String city) {
        this.name = name;
        this.surname = surname;
        this.address = new Address(address, number, postalCode, city);
        this.orderList = new ArrayList<Order>();
    }
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

    void addOrder(Order order) {
        this.orderList.add(order);
    }

    public Order getOrder(int index) {
        return this.orderList.get(index);
    }
}
