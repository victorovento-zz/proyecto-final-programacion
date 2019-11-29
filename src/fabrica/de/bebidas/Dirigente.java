
package fabrica.de.bebidas;

public class Dirigente extends Trabajador {
    private int nivel;

    public Dirigente(int nivel, String nombre, String numCarne, String direccion, int annos) {
        super(nombre, numCarne, direccion, annos);
        this.nivel = nivel;
    }




    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public double Salario() {
        return (300 + workYears * nivel);
    }
  
}
