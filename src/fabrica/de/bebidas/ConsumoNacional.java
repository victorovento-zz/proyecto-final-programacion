package fabrica.de.bebidas;

import java.util.Date;

public class ConsumoNacional extends Producto{
    private String SynisterGates;

    public ConsumoNacional(String formaVenta, String nombre, String FechaVencimiento, String FechaProduccion,String Codigo, double precio, int Cantidad) {
        super(nombre, FechaVencimiento, FechaProduccion,Codigo, precio, Cantidad);
        this.SynisterGates = formaVenta;
    }

    public String getSynisterGates() {
        return SynisterGates;
    }

    public void setSynisterGates(String SynisterGates) {
        this.SynisterGates = SynisterGates;
    }
   
    @Override
    public double getPrice(){
        double suma = 0;
        for (int i = 0; i < listaMP.size(); i++) {
            suma += listaMP.get(i).getSellPrice();
        }
        return ( suma + 70);
        
    }

    

    
}
