import java.util.List;
import java.util.Scanner;

// Clase que representa una tienda y gestiona operaciones relacionadas con productos
class Tienda {
    private List<Producto> productos;  // Lista que almacena los productos de la tienda
    private Scanner scanner;  // Objeto Scanner para leer la entrada del usuario

    // Constructor de la clase Tienda que recibe una lista de productos
    public Tienda(List<Producto> productos) {
        this.productos = productos;
        this.scanner = new Scanner(System.in);
    }

    // Método para registrar un nuevo producto en la tienda
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

    // Método privado para agregar un producto a la lista de productos
    private void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    // Método para procesar una compra, aplicar descuentos y mostrar el recibo
    public void procesarCompra(Scanner carrito) {
        double total = 0;

        System.out.println("Recibo de compra:");

        for (Producto producto : productos) {
            System.out.println(producto);

            System.out.println("¿El producto " + producto.getNombre() + " tiene descuento?");
            System.out.println("(1) Sí   (2) No  ");

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

                    System.out.println(" ");
                    System.out.println(" ");

                    System.out.println("---------------------------------------");
                    System.out.println("RECIBO DE LA COMPRA");
                    System.out.println("---------------------------------------");

                    System.out.println("Descuento aplicado" + porcentajeDescuento);
                    System.out.println("Descuento del " + porcentajeDescuento + "% aplicado a " + producto.getNombre());
                    break;

                case 2:
                    System.out.println("No se aplica ningún descuento");
                    precioFinal = producto.getPrecio();

                    System.out.println("---------------------------------------");
                    System.out.println("RECIBO DE LA COMPRA");
                    System.out.println("---------------------------------------");

                    System.out.println("Descuento aplicado: ninguno");
                    break;
                default:
                    System.out.println("Opción no válida");
                    precioFinal = producto.getPrecio();
                    break;
            }

            total += precioFinal;
        }

        System.out.println("Total de la compra: $" + total);
        System.out.println("---------------------------------------");
    }

    // Método para calcular el precio total de los productos en la tienda
    public double calcularPrecioTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
