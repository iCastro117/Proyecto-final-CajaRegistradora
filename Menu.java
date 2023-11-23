import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Clase principal que contiene el programa principal del sistema de tienda
public class Menu {
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Se crea una lista para almacenar productos
        List<Producto> productos = new ArrayList<>();

        // Se crea un objeto Tienda que gestionará las operaciones relacionadas con los productos
        Tienda tienda = new Tienda(productos);

        // Bucle principal que muestra el menú y realiza acciones según la opción seleccionada por el usuario
        while (true) {
            System.out.println("Menú Principal");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Procesar Compra");
            System.out.println("3. Calcular Precio Total");
            System.out.print("Seleccione una opción: ");

            // Se lee la opción seleccionada por el usuario
            int opcion = scanner.nextInt();

            // Se utiliza un switch para realizar acciones según la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción 1: Registrar un nuevo producto
                    tienda.registrarProducto(scanner);
                    break;
                case 2:
                    // Opción 2: Procesar una compra
                    tienda.procesarCompra(scanner);
                    break;
                case 3:
                    // Opción 3: Calcular el precio total de la compra y mostrarlo
                    double total1 = tienda.calcularPrecioTotal();
                    System.out.println("Precio total de la compra: $" + total1);
                    break;
                case 4:
                    // Opción 4 (en este caso es redundante y realiza la misma acción que la opción 3)
                    double total = tienda.calcularPrecioTotal();
                    System.out.println("Precio total de la compra: $" + total);
                    break;
                default:
                    // Opción por defecto en caso de que el usuario seleccione una opción no válida
                    System.out.println("Opción no válida.");
            }
        }
    }
}
