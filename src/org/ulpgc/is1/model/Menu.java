package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define un menú de platos con nombre, tipo de menú y lista de platos.
 * @version 1.2
 */
public class Menu {

    /* Atributos */
    private List<Dish> dishList;
    private String name;
    private MenuType menuType;

    /** Constructor de la clase Menu.
     *
     * @param name Nombre del menú.
     * @param menuType Tipo del menú.
     * dishList: Lista de platos del menú.
     */
    public Menu(String name, MenuType menuType) {
        this.name = name;
        this.menuType = menuType;
        dishList = new ArrayList();
    }

    /* Getters y setters */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public MenuType getMenuType() {
        return menuType;
    }
    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    /* Métodos */
    public void addDish(String name, String description, int price) {
        Dish dish = new Dish(name, description, price);
        this.dishList.add(dish);
    }
}
