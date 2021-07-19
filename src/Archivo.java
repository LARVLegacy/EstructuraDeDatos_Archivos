
import java.io.*;

public class Archivo {
    
private File f;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;
    
    public int Cantidad(String ruta)
    {
        int pos = 0;
        //paso 1
        f = new File(ruta);
        try
        {
            fr = new FileReader(f);   //paso 2
            br = new BufferedReader(fr);  //paso 3
            //paso 4
            while((br.readLine())!=null)
            {
                pos++;
            }
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return pos;
    }
    
    public List LeerLista(String ruta)
    {
        List list=new List();
        String registro, campos[];
        
        f = new File(ruta);
        try
        {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while((registro=br.readLine())!=null)
            {
                campos=registro.split("    ");
                list.AddLast( new Estudiante (Integer.parseInt(campos[0]),
                                              campos[1],
                                              campos[2],
                                              Double.parseDouble(campos[3])));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return list;
    }
    
public void EscribirLista(List lista, String ruta)
    {
        //paso 1
        f = new File(ruta);
        try{
            fw = new FileWriter(f); //paso 2            
            bw = new BufferedWriter(fw); //paso 3
            //paso 4
            Node aux = lista.getFirst();
            while(aux!=null)
            {
                    
                Estudiante e = (Estudiante)aux.getData();
                    bw.write(e.getIdentificacion() + "  " + e.getNombre() + "  " + e.getCarrera() + "  "
                      + e.getPromedio() + "\n");
                    
                aux = aux.getLink();
            }
            bw.close();  //paso 5
        }       catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}