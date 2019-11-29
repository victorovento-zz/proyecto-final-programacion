
package fabrica.de.bebidas;


public class MP_Nacional extends MateriaPrima{
    private String empresa;

    public MP_Nacional(String NombreEmpresaVende, String Nombre, String Codigo, double precioVenta) {
        super(Nombre, Codigo, precioVenta);
        this.empresa = NombreEmpresaVende;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
}
