package org.ulpgc.is1.model;

/**
 * Clase Dish para definir un plato, con nombre, descripción y precio del mismo.
 * @version 1.0
 */
public class Dish {

    /* Atributos */
    private String name;
    private String description;
    private int price;

    /* Constructor */
    public Dish(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /* Getters y Setters */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
