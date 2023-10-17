package org.ulpgc.is1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase phone para almacenar el teléfono de contacto de los clientes.
 *
 * @version 1.0
 */
public class Phone {

    /* Atributos */
    public String number;

    /**
     * Constructor de la clase Phone.
     *
     * @param phoneNumber String que representa el número teléfonico
     */
    public Phone(String phoneNumber) {
        if (this.isValid(phoneNumber)) {
            this.number = phoneNumber;
        }
    }

    /* Métodos */
    public boolean isValid(String number) {
        Pattern pattern = Pattern.compile("6{1}[0-9]{8}|928{1}[0-9]{6}");
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
    public void setNumber(String number) {
        if (this.isValid(number)) {
            this.number = number;
        } else {
            this.number = "XXXX";
        }
    }
    public String getNumber() {
        return number;
    }
}
