package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void init(OrderManager orderManager) {
        // i. Init. Crear dos clientes.
        orderManager.addCustomer("TychoPersona2", "Quintana", "La Herradura", 157, 35000,"Telde");
        orderManager.addCustomer("Tycho", "Quintana", "La Herradura", 157, 35000,"Telde");
        // ii. Init. Crear dos restaurantes. (*) En el caso que el restaurante tenga un número de teléfono no válido se almacenará el valor: “XXXX”.
        Menu myKidsMenu = new Menu("Menú para niño", MenuType.Kids);
        Menu myDailyMenu = new Menu("Menu diario！", MenuType.Daily);
        orderManager.addRestaurant("La Preferida", "654444444", myKidsMenu);
        orderManager.addRestaurant("Casa Mario", "655555555", myDailyMenu);
        // iii. Init. Crear tres platos diferentes.
        orderManager.addDish("Hamburguesa Ladrón Fantasma", "Hamburguesa de pollo", 13);
        orderManager.addDish("Ensalada bofuri", "Ensalada de verduras del país", 7);
        orderManager.addDish("Super Hot Dog Galaxial Crossing Under Warioware V", "Bocadillo de salchicha", 5);
    }
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        init(orderManager);
        // iv. Imprimir por pantalla los datos del primer restaurante.
        System.out.println("Restaurante " + orderManager.getRestaurant(0).getName() + ", Nº teléfono: " + orderManager.getRestaurant(0).getPhone().getNumber());
        // v. Imprimir por pantalla los datos del segundo cliente.
        System.out.println("Nombre: " + orderManager.getCustomer(1).getName() +  ", Apellidos: "  + orderManager.getCustomer(1).getSurname() + ", dirección: " + orderManager.getCustomer(1).getAddress().getAddressInformation());
        // vi. Imprimir por pantalla los datos del tercer plato.
        System.out.println("Nombre: " + orderManager.getDish(2).getName() + ", descripcion: " + orderManager.getDish(2).getDescription() + ", precio: " + orderManager.getDish(2).getPrice());
        // vii. Crear un pedido por parte del primer cliente, al primer restaurante, que incluya los dos últimos platos del catálogo. (*) Sugerencia: para especificar los platos y la cantidad de ellos, se pueden utilizar dos ArrayList<Integer> que indiquen la posición del plato en el catálogo y la cantidad de dicho plato, respectivamente. (void order(Customer customer, Restaurant restaurant, ArrayList<Integer> dishesId, ArrayList<Integer> quantity))
        List<Integer> dishes = new ArrayList<Integer>();
        List<Integer> quantity = new ArrayList<Integer>();
        dishes.add(1);
        dishes.add(2);
        quantity.add(2);
        quantity.add(2);
        orderManager.order(orderManager.getCustomer(0), orderManager.getRestaurant(0), dishes, quantity);
        // viii. Borrar el segundo cliente.
        orderManager.deleteCustomer(1);
        // ix. Imprimir por pantalla el número de clientes.
        System.out.println(orderManager.numberOfCustomers());;
        // x. Imprimir por pantalla el primer pedido del primer cliente, incluyendo el precio total del pedido.
        Order order = orderManager.getCustomer(0).getOrder(0);
        System.out.println("ID: " + order.getId() + ", cliente: " + order.getCustomer().getName() + ", dirección cliente: " + order.getCustomer().getAddress().getAddressInformation() + ", restaurante: " + order.getRestaurant().getName() + ", precio total: " + order.price());
    }
}
