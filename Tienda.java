import java.util.List;
import java.util.Scanner;

public class Tienda {
    private List<Producto> productos;

    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    public void procesarCompra(Scanner scanner) {
        double total = 0; // Inicializar el total en 0
        System.out.println("******************************");
        System.out.println("Recibo de compra:");
        System.out.println("******************************");
        for (Producto producto : productos) {
            System.out.println(producto + " ");
            System.out.println("******************************");
            System.out.println("¿El producto " + "*" + producto.nombre() + "*" + " tiene descuento? (1) Sí   (2) No   (3) Aplicar descuento personalizado: ");
            System.out.println("******************************");
            int opcion = scanner.nextInt();

            double precioFinal = 0; // Inicializar el precio final en 0

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el porcentaje de descuento (%): ");
                    double porcentajeDescuento = obtenerPrecioNice(scanner);
                    double descuento = producto.precio() * (porcentajeDescuento / 100);
                    precioFinal = producto.precio() - descuento;
                    producto = new Producto(producto.nombre(), precioFinal, producto.codigo());
                    System.out.println("Descuento del " + porcentajeDescuento + "% aplicado a " + producto.nombre());
                    System.out.println("Precio final del producto: " + producto.nombre() + " $" + precioFinal);
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println("******************************");
                    System.out.println("No se aplica ningún descuento");
                    System.out.println("******************************");
                    precioFinal = producto.precio(); // Precio final sin descuento
                    System.out.println("Precio final del producto: " + producto.nombre() + " $" + precioFinal);
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.print("Ingrese el descuento personalizado: %");
                    double descuentoPersonalizado = obtenerPrecioNice(scanner);

                    double descuentoPersonalizadoFinal = producto.precio() * (descuentoPersonalizado / 100);
                    precioFinal = producto.precio() - descuentoPersonalizadoFinal;
                    producto = new Producto(producto.nombre(), precioFinal, producto.codigo());
                    System.out.println("Descuento personalizado de %" + descuentoPersonalizado + " aplicado a " + producto.nombre());
                    System.out.println("Descuento aplicado de: - $" + descuentoPersonalizadoFinal);

                    System.out.println("Precio final del producto: " + producto.nombre() + " $" + precioFinal);
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            total += precioFinal; // Sumar el precio final al total

        }

        System.out.println( " " );
        System.out.println("*****************************");
        System.out.println("Total de la compra: $" + total);
        System.out.println("*****************************");
        System.out.println(" ");

        // Solicitar al usuario un monto recibido y calcular el cambio
        System.out.println("*******************************************");
        System.out.println("Ingrese la cantidad de dinero recibido: ");
        System.out.println("*******************************************");
        double dineroRecibido = obtenerPrecioNice(scanner);

        double cambio = dineroRecibido - total;
        System.out.println(" ");
        System.out.println("*******************************************");
        System.out.println("Cantidad de monto a devolver: $" + cambio);
        System.out.println("*******************************************");

        // Solicitar al usuario un código de producto
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("******************************************************");
        System.out.println("Ingrese un código de producto para obtener información: ");
        System.out.println("******************************************************");
        int codigoBuscado = obtenerCodigoNice(scanner);

        // Buscar y mostrar información sobre el producto correspondiente al código ingresado
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.codigo() == codigoBuscado) {
                System.out.println("--------------------------------------------");
                System.out.println("El producto es " + producto.nombre());
                System.out.println("El precio es $" + producto.precio());
                System.out.println("--------------------------------------------");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un producto con el código " + codigoBuscado);
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
}