import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public record Producto(String nombre, double precio, int codigo) {
    public String toString() {
        return "Producto: " + nombre + "\nPrecio: $" + precio + "\nCodigo: " + codigo;
    }
}

