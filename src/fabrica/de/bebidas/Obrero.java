package fabrica.de.bebidas;


public class Obrero extends Trabajador{
   
    private int categoria;

    public Obrero(int categoria, String nombre, String numCarne, String direccion, int annos) {
        super(nombre, numCarne, direccion, annos);
        this.categoria = categoria;
    }


    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public double Salario() {
        return (200 + workYears * categoria);
    }
}
