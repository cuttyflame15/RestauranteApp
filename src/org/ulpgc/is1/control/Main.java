package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase main que se encarga de comprobar el funcionamiento mínimo de la aplicación.
 *
 * @author Xiao Hui Huang
 * @author Tycho Quintana Santana
 * @link <a href="https://github.com/cuttyflame15/RestauranteApp.git">...</a>
 */
public class Main {

    public static void init(OrderManager orderManager) {
        // i. Init. Crear dos clientes.
        orderManager.addCustomer("Xiao Hui", "Huang", "Practicante Ignacio Rodríguez", 1, 35017,"Las Palmas");
        orderManager.addCustomer("Tycho", "Quintana", "La Herradura", 157, 35000,"Telde");
        // ii. Init. Crear dos restaurantes. (*) En el caso que el restaurante tenga un número de teléfono no válido se almacenará el valor: “XXXX”.
        //Se introduce teléfono incorrecto para comprobar que el programa devuelve "XXXX"
        orderManager.addRestaurant("La Parrilla ardiente", "62600","Menú sabroso", MenuType.Daily);
        orderManager.addRestaurant("Cafetería EII", "655555555","Menú IS1", MenuType.Tasting);
        // iii. Init. Crear tres platos diferentes.
        orderManager.addDish("Filete Kobe", "Filete de carne Kobe, importada de Japón", 400);
        orderManager.addDish("Ensalada bofuri", "Ensalada de verduras frescas variadas", 7);
        orderManager.addDish("Crazy Hot-Dog", "Bocadillo de salchicha con pan de perrito caliente", 5);
    }
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        init(orderManager);
        // iv. Imprimir por pantalla los datos del primer restaurante.
        System.out.println("Restaurante: " + orderManager.getRestaurant(0).getName() + ", Nº teléfono: " + orderManager.getRestaurant(0).getPhone().getNumber() + ", lista de menús: " + orderManager.getRestaurant(0).menuOfRestaurant());
        System.out.println();
        // v. Imprimir por pantalla los datos del segundo cliente.
        System.out.println("Cliente 2: Nombre: " + orderManager.getCustomer(1).getName() +  ", Apellidos: "  + orderManager.getCustomer(1).getSurname() + ", dirección: " + orderManager.getCustomer(1).getAddress().getAddressInformation());
        System.out.println();
        // vi. Imprimir por pantalla los datos del tercer plato.
        System.out.println("Plato: " + orderManager.getDish(2).getName() + ". Descripcion: " + orderManager.getDish(2).getDescription() + ". Precio: " + orderManager.getDish(2).getPrice() + "€");
        System.out.println();
        // vii. Crear un pedido por parte del primer cliente, al primer restaurante, que incluya los dos últimos platos del catálogo. (*) Sugerencia: para especificar los platos y la cantidad de ellos, se pueden utilizar dos ArrayList<Integer> que indiquen la posición del plato en el catálogo y la cantidad de dicho plato, respectivamente. (void order(Customer customer, Restaurant restaurant, ArrayList<Integer> dishesId, ArrayList<Integer> quantity))
        List<Integer> dishes = new ArrayList<>();
        List<Integer> quantity = new ArrayList<>();
        dishes.add(1);
        dishes.add(2);
        quantity.add(2);
        quantity.add(2);
        orderManager.order(orderManager.getCustomer(0), orderManager.getRestaurant(0), dishes, quantity);
        // viii. Borrar el segundo cliente.
        orderManager.deleteCustomer(1);
        // ix. Imprimir por pantalla el número de clientes.
        System.out.println("Número de clientes: " + orderManager.numberOfCustomers());
        System.out.println();
        // x. Imprimir por pantalla el primer pedido del primer cliente, incluyendo el precio total del pedido.
        Order order = orderManager.getCustomer(0).getOrder(0);
        System.out.println("Pedido del primer cliente:\nID: " + order.getId() + "\nNombre: " + order.getCustomer().getName() + "\nApellidos: " + orderManager.getCustomer(0).getSurname() + "\nDirección del cliente: " + order.getCustomer().getAddress().getAddressInformation() + "\nRestaurante: " + order.getRestaurant().getName() + "\nPrecio total: " + order.price() + "€");
    }
}
