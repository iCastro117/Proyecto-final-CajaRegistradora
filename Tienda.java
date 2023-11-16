import java.util.List;

public class Tienda {
    private List<Producto> productos;

    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    public void registrarProducto(String nombre, double precio, int codigo) {
        Producto producto = new Producto(nombre, precio, codigo);
        productos.add(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    public void procesarCompra(List<Producto> carrito) {
        double total = 0.0;
        for (Producto producto : carrito) {
            total += producto.getPrecio();
        }
        System.out.println("Precio total de la compra: $" + total);
    }

    public double calcularPrecioTotal() {
        // Implementa el cálculo del precio total según tus necesidades
        return 0.0;
    }
}
