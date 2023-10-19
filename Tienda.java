import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tienda {
    private List<Producto> productos;

    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    public void procesarCompra(Scanner scanner) {
        double total = 0;
        System.out.println("Recibo de compra:");

        for (Producto producto : productos) {
            System.out.println(producto);

            System.out.println("¿El producto " + producto.getNombre() + " tiene descuento?");
            System.out.println("(1) Sí   (2) No   (3) Aplicar descuento personalizado:");

            int opcion = scanner.nextInt();
            double precioFinal = 0;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el porcentaje de descuento (%): ");
                    double porcentajeDescuento = scanner.nextDouble(); // Lee el porcentaje directamente
                    double descuento = producto.getPrecio() * (porcentajeDescuento / 100);
                    precioFinal = producto.getPrecio() - descuento;
                    producto.setPrecio(precioFinal);
                    System.out.println("Descuento del " + porcentajeDescuento + "% aplicado a " + producto.getNombre());
                    break;
                case 2:
                    System.out.println("No se aplica ningún descuento");
                    precioFinal = producto.getPrecio();
                    break;
                case 3:
                    System.out.print("Ingrese el descuento personalizado (%): ");
                    double descuentoPersonalizado = scanner.nextDouble(); // Lee el descuento personalizado
                    double descuentoPersonalizadoFinal = producto.getPrecio() * (descuentoPersonalizado / 100);
                    precioFinal = producto.getPrecio() - descuentoPersonalizadoFinal;
                    producto.setPrecio(precioFinal);
                    System.out.println("Descuento personalizado de %" + descuentoPersonalizado + " aplicado a " + producto.getNombre());
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            total += precioFinal;
        }

        System.out.println(" ");
        System.out.println("Total de la compra: $" + total);
    }
}
