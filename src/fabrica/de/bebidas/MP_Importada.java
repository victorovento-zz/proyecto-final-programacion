package fabrica.de.bebidas;

public class MP_Importada extends MateriaPrima{
    private String pais;

    public MP_Importada(String Pais, String Nombre, String Codigo, double precioVenta) {
        super(Nombre, Codigo, precioVenta);
        this.pais = Pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
