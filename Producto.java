import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Producto {
    private String nombre;
    private double precio;
    private int codigo;

    public Producto(String nombre, double precio, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String toString() {
        return "Producto: " + nombre + "\nPrecio: $" + precio + "\nCódigo: " + codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
