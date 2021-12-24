package paciente;

import java.util.ArrayList;
import java.util.List;
import visual.*;

/**
 *
 * @author Kevin Ortiz
 */
public final class OperacionesPaciente {

    /**
     *
     */
    public List<Paciente> ListaPersonas = new ArrayList<>();
   
    //constructor
    public OperacionesPaciente() {
        
    }

    //metodos
    public void registraPaciente(String nCedula, String paterno, String materno, String nombre, String genero, String fechaNacimiento, String ubicacionInter) {
        ListaPersonas.add(new Paciente(nCedula, paterno, materno, nombre, genero, fechaNacimiento, ubicacionInter));

        System.out.println("Registro Correcto");
        System.out.println("Añadido:\n"+ListaPersonas);
        System.out.println("El paciente:\n"+buscar("Kev")+"\n");
        System.out.println(comprobar("Kev"));
        
    }

    public Paciente buscar(String cedula) {
        Paciente aux = new Paciente();
        int sw = 0;
        if(ListaPersonas != null && ListaPersonas.size() > 0){
            for(Paciente pac: ListaPersonas){
                if(pac.getnCedula().contains(cedula)){
                
                    sw = 1;
                    aux = pac;
                    System.out.println("Paciente encontrado");
                }  
            }
        }
        if(sw == 0){
            aux = null;
            System.out.println("No encontrado");
        }
        
        /*
        for (Paciente a : ListaPersonas) {

            if (a.getnCedula().equals(cedula)) {
                aux = a;
            }
        }
        */
        
        return aux;
       
    }
    public boolean comprobar(String cedula){
        boolean sb = false;
        for(Paciente i: ListaPersonas){
            if(i.getnCedula().equals(cedula)){
                sb=true;
            }
        }
        return sb;
        
        
    }
    
}
