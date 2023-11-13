// Importaciones necesarias para utilizar las clases List y ArrayList.
import java.util.List;
import java.util.ArrayList;

// La clase Tienda representa un comercio que gestiona productos.
class Tienda {
    private List<Producto> productos; // Lista que almacena los productos disponibles en la tienda.

    // Constructor de la clase Tienda.
    // Inicializa la lista de productos con la proporcionada como parámetro.
    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    // Método para registrar un nuevo producto en la tienda.
    // Recibe el nombre, precio y código del producto a registrar.
    // Crea un nuevo objeto Producto y lo agrega a la lista de productos de la tienda.
    public void registrarProducto(String nombre, double precio, int codigo) {
        Producto producto = new Producto(nombre, precio, codigo);
        productos.add(producto);
        System.out.println("Producto registrado con éxito.");
    }

    // Método para procesar una compra en la tienda.
    // Calcula el precio final de cada producto, aplicando un descuento ficticio del 10%.
    // Muestra un recibo detallado y presenta el total de la compra.
    public void procesarCompra() {
        double total = 0;
        System.out.println("Recibo de compra:");

        // Supongamos que hay un descuento para todos los productos
        boolean aplicarDescuento = true;

        // Itera sobre la lista de productos.
        for (Producto producto : productos) {
            System.out.println(producto); // Muestra los detalles del producto.

            double precioFinal = 0;

            // Aplica un descuento ficticio del 10% si la bandera aplicarDescuento es true.
            if (aplicarDescuento) {
                double porcentajeDescuento = 10.0; // Puede obtenerse de alguna otra fuente.
                double descuento = producto.getPrecio() * (porcentajeDescuento / 100);
                precioFinal = producto.getPrecio() - descuento;
                producto.setPrecio(precioFinal); // Actualiza el precio del producto con descuento.
                System.out.println("Descuento del " + porcentajeDescuento + "% aplicado a " + producto.getNombre());
            } else {
                System.out.println("No se aplica ningún descuento.");
                precioFinal = producto.getPrecio();
            }

            total += precioFinal; // Suma el precio final al total de la compra.
        }

        System.out.println("Total de la compra: $" + total);
    }

    // Método para calcular el precio total de todos los productos en la tienda.
    // Retorna el precio total de los productos.
    public double calcularPrecioTotal() {
        double total = 0;
        // Itera sobre la lista de productos y suma los precios de cada uno.
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}

// La clase Producto representa un artículo en la tienda.
class Producto {
    private String nombre; // Nombre del producto.
    private double precio; // Precio del producto.
    private int codigo;    // Código único del producto.

    // Constructor de la clase Producto.
    // Recibe el nombre, precio y código del producto y los asigna a las variables de instancia.
    public Producto(String nombre, double precio, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    // Método getter para obtener el nombre del producto.
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el precio del producto.
    public double getPrecio() {
        return precio;
    }

    // Método setter para actualizar el precio del producto.
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString que devuelve una representación en cadena del producto.
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", código=" + codigo + "]";
    }
}
