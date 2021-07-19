
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {

        String menu[]={"Crear listas nuevas","Mostrar listas dadas","Mostrar listas nuevas",
                       "Guardar listas nuevas","Leer listas dadas",
                       "Leer listas nuevas","Guardar lista estudiantes que tienen doble solicitud",
                       "Mostrar lista doble solicitud",
                       "Salir"};
        
        String opcion, nombre, carrera;
        int identificacion, i=0;
        double promedio;
        
        Archivo ar = new Archivo(); 
        
        List lista_estampilla = new List();
        List lista_tecnologica = new List();

        List lista_estampilla_prueba = new List();
        List lista_tecnologica_prueba = new List();
        
        List lista_estudiantes_doble = new List();
        
        String tipo_beca, resp="Si";
        String resp1[] ={"Si", "No"};
        String resp2[] ={"Estampilla", "Tecnologica"};
        
        do{
              opcion =(String)JOptionPane.showInputDialog(null,"Seleccione:",
                      "Menu", 1, null, menu, menu[0]);
              
              switch(opcion)
              {
                  case "Crear listas nuevas":
                    
                    while(resp.equals("Si")){
                        
                    identificacion=Integer.parseInt(JOptionPane.showInputDialog("ingrese la identificación"));
                    nombre=JOptionPane.showInputDialog("ingrese el nombre");
                    carrera=JOptionPane.showInputDialog("ingrese la carrera");
                    promedio= Double.parseDouble(JOptionPane.showInputDialog("ingrese el promedio"));
                    
                    tipo_beca = (String)JOptionPane.showInputDialog(null,"Seleccione tipo de beca:","Respuesta",
                            1, null, resp2, resp2[0]);
                    
                    if(tipo_beca.equals("Estampilla"))
                        lista_estampilla_prueba.AddLast(new Estudiante(identificacion, nombre, carrera, promedio));
                    else
                        lista_tecnologica_prueba.AddLast(new Estudiante(identificacion, nombre, carrera, promedio));
                    
                    JOptionPane.showMessageDialog(null,"estudiante creado");
                    
                    resp = (String)JOptionPane.showInputDialog(null,"Seleccione:","Respuesta", 1, null, resp1, resp1[0]);
                    
                    }
                   
                    break;  
                    
                case "Mostrar listas dadas":                                 
                        JOptionPane.showMessageDialog(null,"Lista ProEstampilla:\n"+lista_estampilla.toString());
                        JOptionPane.showMessageDialog(null,"Lista BecaTecnologica:\n"+lista_tecnologica.toString());
                    break;
                    
                case "Mostrar listas nuevas":                                 
                        JOptionPane.showMessageDialog(null,"Lista estampilla-prueba:\n"+lista_estampilla_prueba.toString());
                        JOptionPane.showMessageDialog(null,"Lista tecnologica-prueba:\n"+lista_tecnologica_prueba.toString());
                    break; 
                    
                case "Guardar listas nuevas":
                    ar.EscribirLista(lista_estampilla_prueba, "estampilla-prueba.txt");
                    ar.EscribirLista(lista_tecnologica_prueba, "tecnologica-prueba.txt");
                    
                    JOptionPane.showMessageDialog(null, "Archivos guardado");
                    
                    break;   
                    
                case "Leer listas dadas":
                    lista_estampilla = ar.LeerLista("ProEstampilla.txt");
                    lista_tecnologica = ar.LeerLista("BecaTecnologica.txt");
                    JOptionPane.showMessageDialog(null, "Archivos leído");
                    break;
                    
                case "Leer listas nuevas":
                    lista_estampilla_prueba = ar.LeerLista("estampilla-prueba.txt");
                    lista_tecnologica_prueba = ar.LeerLista("tecnologica-prueba.txt");
                    JOptionPane.showMessageDialog(null, "Archivos leído");
                    break;
                    
                case "Guardar lista estudiantes que tienen doble solicitud":
                    
                    lista_estudiantes_doble = lista_estampilla.List_doble_solicitud(lista_tecnologica);
                    ar.EscribirLista(lista_estudiantes_doble, "Estudiantes doble solicitud.txt");
                    
                    break;
                    
                case "Mostrar lista doble solicitud":
                
                    JOptionPane.showMessageDialog(null,"Lista de estudiantes que tienen doble solicitud:\n"
                            +lista_estudiantes_doble.toString());
                    
                    break;
              }
        }while(!opcion.equals("Salir"));
//        ar.EscribirVector(vector, "personas.txt");
    }
    
}