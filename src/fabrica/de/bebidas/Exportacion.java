package fabrica.de.bebidas;

import java.util.Date;

public class Exportacion extends Producto{
    private String categoria;
    

    public Exportacion(String Categoria, String nombre, String FechaVencimiento, String FechaProduccion,String Codigo, double precio, int Cantidad) {
        super(nombre, FechaVencimiento, FechaProduccion,Codigo, precio, Cantidad);
        this.categoria = Categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public double getPrice(){
        double suma = 0;
        for (int i = 0; i < listaMP.size(); i++) {
            suma += listaMP.get(i).getSellPrice();
        }
        return (Double.parseDouble(categoria) * (suma + 50));
        
        
    }
 
}
