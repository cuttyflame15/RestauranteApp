package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase de restaurante con nombre, teléfono y una lista de menús, con método para añadir menús a la lista.
 * @version 1.5
 */
public class Restaurant {

    /* Atributos */
    private List<Menu> menuList;
    private String name;
    private Phone phone;

    private List<Order> orderList;



    /* Constructor */
    public Restaurant(String name, String input_phone, String menuName, MenuType menuType) {
        this.name = name;
        this.phone = new Phone(input_phone);
        this.menuList = new ArrayList();
        this.addMenu(menuName, menuType);
        this.orderList = new ArrayList();
    }

    /* Getters y setters */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    public List<Order> getOrderList() {
        return orderList;
    }
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setOrderList (List<Order> orderList) {
        this.orderList = orderList;
    }

    /* Métodos */
    public void addMenu(String name, MenuType menuType) {
        Menu menu = new Menu(name, menuType);
        this.menuList.add(menu);
    }
    public void deleteMenu(int i) {
        if (i >= 0 && i < menuList.size()) {
            this.menuList.remove(i);
        }
    }


    public void addOrder(Order order) {
        this.orderList.add(order);
    }
    public void deleteOrder(int i) {
        if (i >= 0 && i < orderList.size()) {
            this.orderList.remove(i);
        }
    }

    public String menuOfRestaurant () {
        String result = "";
        for (Menu menu: this.menuList) {
            result = result + menu.getName() + ", tipo de menú: " + menu.getMenuType() + " ";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }
}
