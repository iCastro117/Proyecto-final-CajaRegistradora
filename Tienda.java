import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Tienda {
    private List<Producto> productos;

    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    public void registrarProducto(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Código del producto: ");
        int codigo = scanner.nextInt();

        Producto producto = new Producto(nombre, precio, codigo);
        productos.add(producto);
        System.out.println("Producto registrado con éxito.");
    }

    public void procesarCompra(Scanner scanner) {
        double total = 0;
        System.out.println("Recibo de compra:");
        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.print("¿El producto " + producto.getNombre() + " tiene descuento? (1) Sí   (2) No: ");
            int opcion = scanner.nextInt();
            double precioFinal = 0;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el porcentaje de descuento (%): ");
                    double porcentajeDescuento = scanner.nextDouble();
                    double descuento = producto.getPrecio() * (porcentajeDescuento / 100);
                    precioFinal = producto.getPrecio() - descuento;
                    producto.setPrecio(precioFinal);
                    System.out.println("Descuento del " + porcentajeDescuento + "% aplicado a " + producto.getNombre());
                    break;
                case 2:
                    System.out.println("No se aplica ningún descuento.");
                    precioFinal = producto.getPrecio();
                    break;
                default:
                    System.out.println("Opción no válida. No se aplica descuento.");
                    precioFinal = producto.getPrecio();
                    break;
            }

            total += precioFinal;
        }

        System.out.println("Total de la compra: $" + total);
    }

    public double calcularPrecioTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
