package fabrica.de.bebidas;

public abstract class MateriaPrima {
    protected String name;
    protected String code;
    protected double sellPrice;

    public MateriaPrima(String Nombre, String Codigo, double precioVenta) {
        this.name = Nombre;
        this.code = Codigo;
        this.sellPrice = precioVenta;

            }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    
 
           
}
