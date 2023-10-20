package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de restaurante con nombre, teléfono y una lista de menús, con método para añadir menús a la lista.
 * @version 1.3
 */
public class Restaurant {

    /* Atributos */
    private List<Menu> menuList;
    private String name;
    private Phone phone;

    /** Constructor de Restaurant
     *
     * @param name Nombre del restaurante.
     * @param input_phone Teléfono introducido del restaurante
     * menuList: Lista de menús.
     */
    public Restaurant(String name, String input_phone) {
        this.name = name;
        this.phone = new Phone(input_phone);
        this.menuList = new ArrayList();
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

    /* Métodos */
    public void addMenu(String name, MenuType menuType) {
        Menu menu = new Menu(name, menuType);
        this.menuList.add(menu);
    }

}
