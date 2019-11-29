package fabrica.de.bebidas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class FabricaBebidas {    

    private Vector<Producto> listaProductos;
    private Vector<Trabajador> listaTrabajadores;
    private Vector<Camion> listaCamiones;
    private Vector<MateriaPrima> listaMP;
    private int horasCarga;

    public FabricaBebidas() {
        listaProductos = new Vector<Producto>();
        listaTrabajadores = new Vector<Trabajador>();
        listaCamiones = new Vector<Camion>();
        horasCarga = 0;
        listaMP= new Vector<MateriaPrima>();
    }

    public Vector<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Vector<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void AddMateriaPrimaDadoProducto(String codigo, MateriaPrima nueva) {
        int pos = BuscarProducto(codigo);
        if (pos != -1) {
            listaProductos.get(pos).addMateriaPrima(nueva);
        }
    }

    public void DelWorker(String CI) {
        int pos = SearchWorker(CI);
            listaTrabajadores.remove(pos);
    }

    public int SearchWorker(String CI) {
        for (int i = 0; i < listaTrabajadores.capacity(); i++) {
            if (listaTrabajadores.get(i).getCI().equals(CI)) {
                return i;
            }
        }
        return -1;
    }

    public int BuscarProducto(String codigo) {
        for (int i = 0; i < listaProductos.size(); i++) {
            String c=listaProductos.get(i).getCode();
            if (c.equals(codigo)) {
                return i;
                
            }
        }
        return -1;
    }

    public Vector<Camion> SalidaCamiones() {
        Vector<Camion> cmp = new Vector();
        int h = 0;
        if (listaCamiones != null) {
            while (h <= 4) {
                if (listaCamiones.isEmpty()) {
                    break;
                }
                if (h + listaCamiones.get(0).getTiempoCarga() > 4) {
                    break;
                } else {
                    h += listaCamiones.get(0).getTiempoCarga();
                    cmp.add(listaCamiones.get(0));
                    listaCamiones.remove(0);
                }
            }
        }
        horasCarga += h;
        return cmp;
    }

    public Vector<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }
    

    public void setListaTrabajadores(Vector<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public void AddProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void AddTrabajador(Trabajador trabajador) {
        listaTrabajadores.add(trabajador);
    }

    public void AddCamion(Camion camion) {
        listaCamiones.add(camion);
    }

//          DEVUELVE UN LISTADO DE TRABAJADORES DE UNA CATEGORIA DADA
    public Vector<Trabajador> TrabajadoresDeUnaCategoria(int categoria) {
        Vector<Trabajador> tCategoria = new Vector<>();
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i) instanceof Obrero) {
                if (((Obrero) listaTrabajadores.get(i)).getCategoria() == categoria) {
                    tCategoria.add(listaTrabajadores.get(i));
                }
            }
        }
        return tCategoria;
    }

    //       DEVUELVE UN LISTADO DE TODOS LOS DIRIGENTES
    public Vector<Dirigente> ListadoDeLosDirigentes() {
        Vector<Dirigente> listaDirigentes = new Vector<>();
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i) instanceof Dirigente) {
                listaDirigentes.add((Dirigente) listaTrabajadores.get(i));
            }
        }
        return listaDirigentes;
    }

    //        CANTIDAD TOTAL DE DINERO A PAGAR LA EMPRESA A LOS TRABAJADORES
    public double CantidadDeDineroAPagarLaFabrica() {
        double suma = 0;
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i) instanceof Obrero) {
                suma += listaTrabajadores.get(i).Salario() + 5 * horasCarga;
            } else {
                suma += listaTrabajadores.get(i).Salario();
            }
        }
        return suma;
    }

    //       CANTIDAD DE DINERO TOTAL PROPORCIONADO POR LA VENTA DE PRODUCTOS
    public double VentaDeProductos() {
        double suma = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
            suma += listaProductos.get(i).getPrice();
        }
        return suma;
    }

    //        COSTO TOTAL DE LA PRODUCCION 
    public double CostoDeProduccion() {
        double suma = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
            for (int j = 0; j < listaProductos.get(i).listaMP.size(); j++) {
                suma += listaProductos.get(i).listaMP.get(j).getSellPrice();
            }
        }
        return suma;
    }
    
    public double getCostoTotal(){
        double suma = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
        suma+=listaProductos.get(i).getCostoTotal();
        }
     return suma;   
    }
    public void GuardarListTrabajadores() throws IOException {
        FileWriter fw = new FileWriter("trabajadores.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            out.print(listaTrabajadores.get(i).getName() + "," + listaTrabajadores.get(i).getCI() + "," + listaTrabajadores.get(i).getAddress() + "," + listaTrabajadores.get(i).getWorkYears());
            if (listaTrabajadores.get(i) instanceof Obrero) {
                out.println(",obrero," + ((Obrero) listaTrabajadores.get(i)).getCategoria());
            }
            if (listaTrabajadores.get(i) instanceof Dirigente) {
                out.println(",dirigente," + ((Dirigente) listaTrabajadores.get(i)).getNivel());
            }
        }
        
        out.close();
    }
    
       public void GuardarListProductos() throws IOException {
        FileWriter fw = new FileWriter("Productos.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        //String formaVenta, String name, String fechaV, String fechaP,String code, double price, int cantidad
        for (int i = 0; i < listaProductos.size(); i++) {
            out.print(listaProductos.get(i).getName() + "," + listaProductos.get(i).getFechaV() + "," + 
                      listaProductos.get(i).getFechaP() + "," + listaProductos.get(i).getCode()+ "," 
                    +listaProductos.get(i).getPrecioInicial()+","+listaProductos.get(i).getCantidad());
            
            
            if (listaProductos.get(i) instanceof ConsumoNacional) {
                out.println(",Nacionales," + ((ConsumoNacional) listaProductos.get(i)).getSynisterGates());
                System.out.println("Añadiendo Naciona aL Vector");
            }
            if (listaProductos.get(i) instanceof Exportacion) {
                out.println(",Exportacion," + ((Exportacion) listaProductos.get(i)).getCategoria());
            }
        }
        out.close();
    }
        public void CargarProductos() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Productos.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] aux;
        while (line != null) {
            //String formaVenta, String name, String fechaV, String fechaP,String code, double price, int cantidad
            aux = line.split(",");
            if (aux[6].equalsIgnoreCase("nacionales")) {
                String formaVenta=aux[7];
                String nombre=aux[0];
                String FechaV=aux[1];
                String FechaP=aux[2];
                String Codigo=aux[3];
                double Precio=Double.parseDouble(aux[4]);
                int Cantidad=Integer.parseInt(aux[5]);
                ConsumoNacional nuevo = new ConsumoNacional(formaVenta, nombre, FechaV, FechaP,Codigo,Precio,Cantidad);
                listaProductos.add(nuevo);
            }
            else if (aux[6].equalsIgnoreCase("exportacion")) {
                Exportacion nuevo = new Exportacion(aux[7], aux[0], aux[1], aux[2],aux[4],Double.parseDouble(aux[4]),Integer.parseInt(aux[5]));
                listaProductos.add(nuevo);
            }
            line = br.readLine();
        }
        br.close();
    }
       

    public void CargarTrabajadores() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("trabajadores.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] aux;
        while (line != null) {
            aux = line.split(",");
            if (aux[4].equalsIgnoreCase("obrero")) {
                Obrero nuevo = new Obrero(Integer.valueOf(aux[5]), aux[0], aux[1], aux[2], Integer.valueOf(aux[3]));
                listaTrabajadores.add(nuevo);
            }
            if (aux[4].equalsIgnoreCase("dirigente")) {
                Dirigente nuevo = new Dirigente(Integer.valueOf(aux[5]), aux[0], aux[1], aux[2], Integer.valueOf(aux[3]));
                listaTrabajadores.add(nuevo);
            }
            line = br.readLine();
        }
        br.close();
    }

public void GuardarListMateriales(String cod,MateriaPrima m) throws IOException {
        FileWriter fw = new FileWriter("Materias.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        //String formaVenta, String name, String fechaV, String fechaP,String code, double price, int cantidad
        for (int i = 0; i < listaProductos.get(i).listaMP.size(); i++) {
            out.print(listaProductos.get(i).listaMP.get(i).getName() + "," + listaProductos.get(i).listaMP.get(i).getCode()+ "," + 
                      listaProductos.get(i).listaMP.get(i).getSellPrice());
            
            if (listaProductos.get(i).listaMP.get(i) instanceof MP_Nacional) {
                out.println(",Nacionales," + ((MP_Nacional) listaProductos.get(i).listaMP.get(i)).getEmpresa()+","+cod);
                System.out.println("Añadiendo Naciona aL Vector");
            }
            if (listaProductos.get(i).listaMP.get(i) instanceof MP_Importada) {
                out.println(",Importadas," + ((MP_Importada) listaProductos.get(i).listaMP.get(i)).getPais()+","+cod);
            }
        }
        out.close();
    }

public void CargarMaterias() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Materias.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] aux;
        while (line != null) {
            aux = line.split(",");
            if (aux[3].equalsIgnoreCase("Nacionales")) {
                //String NombreEmpresaVende, String Nombre, String code, double precioVenta
                MP_Nacional nuevo = new MP_Nacional(aux[4],aux[1],aux[5],Double.parseDouble(aux[2]));
                AddMateriaPrimaDadoProducto(aux[5], nuevo);
                System.out.println(aux[5]+"Materias");
                System.out.println("Logguer");
            }
            if (aux[3].equalsIgnoreCase("Importadas")) {
                MP_Importada nuevo = new MP_Importada(aux[4],aux[1],aux[5],Double.parseDouble(aux[2]));
                AddMateriaPrimaDadoProducto(aux[5], nuevo);
                
            }
            
            line = br.readLine();
        }
        br.close();
    }

public void guardarCamiones() throws IOException{
FileWriter fw = new FileWriter("Camiones.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        for (int i = 0; i < listaCamiones.size(); i++) {
            out.println(listaCamiones.get(i).getChapa()+","+listaCamiones.get(i).getTiempoCarga());
        }
        out.close();
}
public void cargarCamiones() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("Camiones.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] aux;
        while (line != null) {
            aux = line.split(",");
            listaCamiones.add(new Camion(aux[0],Integer.parseInt(aux[1])));
            line = br.readLine();
        }
        br.close();


}
public double calcularCamiones(){
    
    double horas = 0;
    int contador=0;
    for (int i = 0; i < listaCamiones.size(); i++) {
    horas+=listaCamiones.get(i).getTiempoCarga();
    }
    for (int i = 0; i < listaTrabajadores.size(); i++) {
        if (listaTrabajadores.get(i) instanceof Obrero) {
        contador++;   
        }
    
    }
    return horas * contador * 5;
}

}
