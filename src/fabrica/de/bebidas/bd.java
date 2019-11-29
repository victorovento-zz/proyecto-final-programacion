package fabrica.de.bebidas;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bd {
    private String nombre="productos.txt";
    BufferedReader br;
    BufferedWriter bw;
    FileReader fr;
    FileWriter fw;
    PrintWriter out;
    File f1 = new File ("db.dbi");
    int cantReal;
    

    public bd() {
        cantReal = 0;       
        try {
            fw = new FileWriter(f1, true);
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
        } catch (IOException ex) {
            Logger.getLogger(bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void adicionarProducto(Producto[] pr){
        for (int i = 0; i < pr.length; i++) {
        out.println(pr[i].getCode()+" ,"+pr[i].getName()+ " ,"+pr[i].getFechaP()+ " ,"+pr[i].getFechaV()+ " ,"+pr[i].getCantidad()+ " ,"+pr[i].getPrice());
        cantReal++;
        System.out.println("Producto añadido correctamente");        
        }
       out.close();
    
    }
    public void cerrarFlujo(){
    out.close();
    }
    public void cargarDatos(){
    String texto = new String();
    try {      
        BufferedReader br = new BufferedReader(new FileReader("db.dbi"));   
        String s;   
        while((s = br.readLine()) != null)    
        texto += s;
        br.close(); 
        String dato[];
        dato = texto.split(",");
        for (int i = 0; i < dato.length; i++) {
        System.out.println(dato[i]);   
        }
    }
    catch (java.io.FileNotFoundException fnfex) {   
        System.out.println ("Archivo no encontrado: " + fnfex); } catch (IOException ex) { 
            Logger.getLogger(bd.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    
    }
    public void modificarProducto(String p){

         
    }
    public void setCantReal(int z){
    cantReal = z;
    }
}
