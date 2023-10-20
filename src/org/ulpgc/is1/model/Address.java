package org.ulpgc.is1.model;

import java.util.Objects;

/**
 * Clase Address para definir una dirección con calle, número, código postal
 * y ciudad
 *
 * @version 1.0
 */

public class Address {

    /* Atributos */
    private String street;
    private int number;
    private int postalCode;
    private String city;


    /**
     * Constructor de la clase.
     *
     * @param street String que representa la calle.
     * @param number int que representa el número de la dirección.
     * @param postalCode int que representa el número del código postal.
     * @param city String que representa el nombre de la ciudad.
     */
    public Address(String street, int number, int postalCode, String city) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    /* Getters y Setters*/

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    /* Métodos */
    public String getAddressInformation() {
        return getStreet() + ", "  + getNumber() +  ", "  + getPostalCode() +  ", "  + getCity();
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Método equals para poder comparar Customers
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && postalCode == address.postalCode && Objects.equals(street, address.street) && Objects.equals(city, address.city);
    }
}
