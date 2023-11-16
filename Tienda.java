import java.util.List;

public class Tienda {
    private List<Producto> productos;

    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    public void registrarProducto(String nombre, double precio, int codigo) {
        agregarProducto(new Producto(nombre, precio, codigo));
    }

    private void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    public void procesarCompra(List<Producto> carrito) {
        double total = 0.0;
        for (Producto producto : carrito) {
            total += producto.getPrecio();
        }
         double total = 0;
        System.out.println("Recibo de compra:");

        for (Producto producto : productos) {
            System.out.println(producto);

            System.out.println("¿El producto " + producto.getNombre() + " tiene descuento?");
            System.out.println("(1) Sí   (2) No   (3) Aplicar descuento personalizado:");

            System.out.print("¿El producto " + producto.getNombre() + " tiene descuento? (1) Sí   (2) No: ");
            int opcion = scanner.nextInt();
            double precioFinal = 0;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el porcentaje de descuento (%): ");
                    double porcentajeDescuento = scanner.nextDouble(); // Lee el porcentaje directamente
                    double porcentajeDescuento = scanner.nextDouble();
                    double descuento = producto.getPrecio() * (porcentajeDescuento / 100);
                    precioFinal = producto.getPrecio() - descuento;
                    producto.setPrecio(precioFinal);
                    System.out.println("Descuento del " + porcentajeDescuento + "% aplicado a " + producto.getNombre());
                    break;
                case 2:
                    System.out.println("No se aplica ningún descuento");
                    System.out.println("No se aplica ningún descuento.");
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
                    System.out.println("Opción no válida. No se aplica descuento.");
                    precioFinal = producto.getPrecio();
                    break;
            }

            total += precioFinal;
        }

        System.out.println(" ");
        System.out.println("Total de la compra: $" + total);
    }
    }

    public double calcularPrecioTotal() {
                double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        return 0.0;
    }
}

