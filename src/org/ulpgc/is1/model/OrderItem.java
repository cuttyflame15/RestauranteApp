package org.ulpgc.is1.model;

/**
 * Clase OrderItem para almacenar los platos y cantidades del pedido.
 *
 * @version 1.0
 */
public class OrderItem {

    /* Atributos */
    private int quantity;
    private Dish dish;

    /**
     * Constructor de la clase OrderItem.
     *
     * @param dish Un objeto de la clase Disco que represente al disco.
     * @param quantity int que represente la cantidad de raciones del plato.
     */
    public OrderItem(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }



    /* Métodos */
    public Dish getDish() {
        return this.dish;
    }
    public void setDish(Dish dish) {
        this.dish = dish;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
