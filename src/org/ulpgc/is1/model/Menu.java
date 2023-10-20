package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que define un menú de platos con nombre, tipo de menú y lista de platos.
 * @version 1.2
 */
public class Menu {

    /* Atributos */
    private List<Dish> dishList;
    private String name;
    private MenuType menuType;

    /* Constructor */
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Menu menu = (Menu) other;
        return Objects.equals(name, menu.name) && Objects.equals(menuType, menu.menuType);
    }


    public void deleteDish(int i) {
        if (i >= 0 && i < dishList.size()) {
            this.dishList.remove(i);
        }
    }
}
