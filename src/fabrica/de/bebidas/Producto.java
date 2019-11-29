package fabrica.de.bebidas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

public abstract class Producto implements Serializable{
    protected String name;
    protected String fechaV;
    protected String fechaP;
    protected String code;
    protected double price;
    protected int cantidad;
    protected Vector<MateriaPrima> listaMP;

    public Producto(String nombre, String FechaVencimiento, String FechaProduccion,String Codigo, double precio, int Cantidad) {
        this.name = nombre;
        this.fechaV = FechaVencimiento;
        this.fechaP = FechaProduccion;
        this.code= Codigo;
        this.price = precio;
        this.cantidad = Cantidad;
        this.listaMP = new Vector<>();
        
    }

    public void addMateriaPrima(MateriaPrima e){
    listaMP.add(e);
    }

    public String getName() {
        return name;
    }

    public String getFechaV() {
        return fechaV;
    }

    public String getFechaP() {
        return fechaP;
    }

    public String getCode() {
        return code;
    }

    public abstract double getPrice();
    
    public int getCantidad() {
        return cantidad;
    }
           public void GuardarListMateriales() throws IOException {
        FileWriter fw = new FileWriter("Materias.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        
        for (int i = 0; i < listaMP.size(); i++) {
            out.print(listaMP.get(i).getName() + "," + listaMP.get(i).getCode()+ "," + 
                      listaMP.get(i).getSellPrice());
            
            if (listaMP.get(i) instanceof MP_Nacional) {
                out.println(",Nacionales," + ((MP_Nacional) listaMP.get(i)).getEmpresa());
                System.out.println("Añadiendo Naciona aL Vector");
            }
            if (listaMP.get(i) instanceof MP_Importada) {
                out.println(",Importadas," + ((MP_Importada) listaMP.get(i)).getPais());
            }
        }
        out.close();
    }
           
public void CargarMaterias() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("trabajadores.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] aux;
        while (line != null) {
            aux = line.split(",");
            if (aux[3].equalsIgnoreCase("Nacionales")) {
                MP_Nacional nuevo = new MP_Nacional(aux[0],aux[1],aux[2],Double.parseDouble(aux[4]));
                listaMP.add(nuevo);
            }
            if (aux[4].equalsIgnoreCase("Importadas")) {
                MP_Importada nuevo = new MP_Importada(aux[0],aux[1],aux[2],Double.parseDouble(aux[4]));
                listaMP.add(nuevo);
            }
            line = br.readLine();
        }
        br.close();
    }
    public double getPrecioInicial() {
        return price;
    }
    
    public double getCostoTotal(){
        double suma = 0;
        for (int i = 0; i < listaMP.size(); i++) {
        suma +=listaMP.get(i).getSellPrice();
        }
        System.out.println(suma);
    return suma;
    }
    
    
}
