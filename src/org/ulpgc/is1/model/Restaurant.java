package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase de restaurante con nombre, teléfono y una lista de menús, con método para añadir menús a la lista.
 * @version 1.7
 */
public class Restaurant {

    /* Atributos */
    private List<Menu> menuList;
    private String name;
    private Phone phone;

    private List<Order> orderList;


    /** Constructor
     *
     * @param name Nombre del restaurante.
     * @param input_phone Teléfono del restaurante.
     * @param menuName Nombre del menú.
     * @param menuType Tipo del menú.
     */
    public Restaurant(String name, String input_phone, String menuName, MenuType menuType) {
        this.name = name;
        this.phone = new Phone(input_phone);
        this.menuList = new ArrayList<>();
        this.addMenu(menuName, menuType);
        this.orderList = new ArrayList<>();
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

    /* Métodos */
    public void addMenu(String name, MenuType menuType) {
        Menu menu = new Menu(name, menuType);
        if (!menuList.contains(menu)) {
            this.menuList.add(menu);
        }
    }
    public void deleteMenu(int i) {
        if (i >= 0 && i < menuList.size()) {
            this.menuList.remove(i);
        }
    }

    //Un restaurante puede tener pedidos repetidos.
    public void addOrder(Order order) {
        this.orderList.add(order);
    }
    public void deleteOrder(int i) {
        if (i >= 0 && i < orderList.size()) {
            this.orderList.remove(i);
        }
    }

    //Se sugiere usar un StringBuilder pero no nos lo han enseñado aún, así que se descarta.
    public String menuOfRestaurant () {
        String result = "";
        for (Menu menu: this.menuList) {
            result = result + menu.getName() + ", tipo de menú: " + menu.getMenuType() + " ";
        }
        return result;
    }

    // Método equals() para que el método .contains() funcione correctamente.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }
}
