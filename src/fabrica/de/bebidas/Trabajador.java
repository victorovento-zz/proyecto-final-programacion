package fabrica.de.bebidas;
import java.util.Vector;

public abstract class Trabajador {
    protected String name;
    protected String CI;
    protected String address;
    protected int workYears;
    protected Vector<Obrero> listaObreros;
    protected Vector<Dirigente> listaDirigentes;

    public Trabajador(String nombre, String numCarne, String direccion, int annos) {
        this.name = nombre;
        this.CI = numCarne;
        this.address = direccion;
        this.workYears = annos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWorkYears() {
        return workYears;
    }

    public void setWorkYears(int annosDeW) {
        this.workYears = annosDeW;
    }
    
    public abstract double Salario();
}
