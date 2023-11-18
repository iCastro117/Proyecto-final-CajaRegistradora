import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        Tienda tienda = new Tienda(productos);

        while (true) {
            System.out.println("Menú Principal");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Procesar Compra");
            System.out.println("3. Calcular Precio Total");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    tienda.registrarProducto(scanner);
                    break;
                case 2:
                    tienda.procesarCompra(scanner);
                    break;
                case 3:
                    double total = tienda.calcularPrecioTotal();
                    System.out.println("Precio total de la compra: $" + total);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
