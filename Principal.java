import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        System.out.print("Ingrese la cantidad de productos: ");
        int cantidadProductos = obtenerCodigoNice(scanner);

        for (int i = 0; i < cantidadProductos; i++) {
            scanner.nextLine();

            System.out.println("Producto #" + (i + 1));
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio del producto: ");
            double precio = obtenerPrecioNice(scanner);

            System.out.print("Código del producto: ");
            int codigo = obtenerCodigoNice(scanner);

            Producto producto = new Producto(nombre, precio, codigo);
            productos.add(producto);
        }

        Tienda tienda = new Tienda(productos);
        tienda.procesarCompra(scanner);
    }

    private static int obtenerCodigoNice(Scanner scanner) {
        while (true) {
            try {
                int numero = scanner.nextInt();
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Por favor, ingrese un número entero positivo.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número entero positivo válido.");
                scanner.nextLine();
            }
        }
    }

    private static double obtenerPrecioNice(Scanner scanner) {
        while (true) {
            try {
                double numero = scanner.nextDouble();
                if (numero >= 0) {
                    return numero;
                } else {
                    System.out.println("Por favor, ingrese un número decimal no negativo.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
                scanner.nextLine();
            }
        }
    }
}
