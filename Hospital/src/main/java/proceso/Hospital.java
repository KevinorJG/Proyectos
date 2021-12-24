
package proceso;

import java.util.ArrayList;
import java.util.List;
import medico.Medico;

/**
 *
 * @author Kevin Ortiz
 */
public class Hospital extends Medico{
    
     List<Medico> ListaMedico;
     
     //constructor
    public Hospital() {
        ListaMedico = new ArrayList<>(); 
    }
     
    //metodo para registrar los medicos
    public void registrarMedicos(String carnet, String nombre,String apellidos, String genero, String horario, String lugarDeOficio){
        Medico medicos = new Medico();
        //añadiendo a la clase padre Medico
        this.setCarnet(carnet);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setGenero(genero);
        this.setLugarDeOficio(lugarDeOficio);
        this.setHorario(horario);
        
        medicos.setCarnet(carnet);
        medicos.setNombre(nombre);
        medicos.setApellidos(apellidos);
        medicos.setGenero(genero);
        medicos.setLugarDeOficio(lugarDeOficio);
        medicos.setHorario(horario);
        
         ListaMedico.add(medicos);
         if(ListaMedico.size() == 0){
             System.out.println("Arreglo vacion");
         }else{
             System.out.println("Registro Correcto");
         }
        
        
    }
    
    //metodo para buscar los medicos
    public Medico buscarMedicos(String Carnet) {
        Medico Medicos = new Medico();
        int a = 0;
        if (ListaMedico != null && ListaMedico.size() > 0) {
            for (Medico i : ListaMedico) {
                if (i.getCarnet().equalsIgnoreCase(Carnet)) {
                    a = 1;
                    Medicos = i;
                }
            }
        }
        if (a == 0) {
            Medicos = null;
        }
        return Medicos;
    }
    
    //metodo para mostrar los medicos
    public void listadoMedico(){
        for(Medico medicos : ListaMedico){
            mostrarDatos();
        }
    }
    
    //Listado de pacientes por un determinado genero
    public void pacienteGenero(){
        System.out.println("Digite el genero para listar los medicos F/M");
        String genero = Leer.dato();
        for(Medico medicos:ListaMedico){
          if(medicos.getGenero().equalsIgnoreCase(genero)) {
              mostrarDatos();
          } 
        }
    }
    public void mostrarDatos() {
       
        System.out.println("Nro. Carnet: " + getCarnet());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Genero: " + getGenero());
        System.out.println("Hospital de trabajo: " + getLugarDeOficio());
        }
    
    
    //getter y setter

    public List<Medico> getListaMedico() {
        return ListaMedico;
    }

    public void setListaMedico(List<Medico> ListaMedico) {
        this.ListaMedico = ListaMedico;
    }

    
    
    
}
