package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define un menú de platos con nombre, tipo de menú y lista de platos.
 * @version 1.0
 */
public class Menu {



    /* Atributos */
    private List<Dish> dishList;
    private String name;
    private MenuType menuType;



    /* Constructor */
    public Menu(String name) {
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

    public List<Dish> getDishList() {
        return dishList;
    }
    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    /* Métodos */
    public void addDish() {

    }
}
