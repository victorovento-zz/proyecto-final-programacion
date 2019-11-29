package fabrica.de.bebidas;

public class Camion {
    private String chapa;
    private int tiempoCarga;

    public Camion(String chapa, int tiempoDeCarga) {
        this.chapa = chapa;
        this.tiempoCarga = tiempoDeCarga;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public int getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(int tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }
    
    
    
}
