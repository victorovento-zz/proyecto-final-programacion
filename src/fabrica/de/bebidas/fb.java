package fabrica.de.bebidas;
import java.util.Vector;

public class fb {
    private Vector<Producto> listaProductos; 

    public fb() {
        this.listaProductos= new Vector<>();
       }
    public void addProducto(Producto e){
    listaProductos.add(e);
    }
}
