public class Producto {
    // Atributos que describen el producto
    private String nombre;   // Nombre del producto
    private double precio;   // Precio del producto
    private int codigo;      // Código único del producto

    // Constructor para crear un nuevo Producto
    public Producto(String nombre, double precio, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    // Métodos para obtener y establecer el nombre del producto
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y establecer el precio del producto
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Métodos para obtener y establecer el código del producto
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Método para imprimir información detallada del producto
    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Código: " + codigo);
    }

    // Método principal para demostrar el uso de la clase Producto
    public static void main(String[] args) {
        // Crear un nuevo producto
        Producto producto1 = new Producto("Camiseta", 25.99, 1001);

        // Mostrar información inicial del producto
        System.out.println("Información Inicial del Producto:");
        producto1.mostrarInformacion();

        // Modificar información del producto
        producto1.setPrecio(29.99);
        producto1.setNombre("Camiseta de Manga Larga");

        // Mostrar información actualizada del producto
        System.out.println("\nInformación Actualizada del Producto:");
        producto1.mostrarInformacion();
    }
}

