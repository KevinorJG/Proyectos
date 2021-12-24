package paquete;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperacionesPaciente {
    Scanner x = new Scanner(System.in);
    List<Paciente>ListaPersona;

    public OperacionesPaciente() {
        ListaPersona = new ArrayList<>();
    }
    //registro de pacientes, adicionar datos a atributos correspondientes
    //adicionar sintomas
    //guardar a la lista el objeto
    public void registrarPaciente(){
         Paciente paciente = new Paciente();
         paciente.llenarDatos(); 
         //adicionando el paciente a la lista
         ListaPersona.add(paciente);
         System.out.println("Paciente registrado");
    }
    
    //listando todos los pacientes
    public void ListadoDePaciente(){
        for(Paciente paciente: ListaPersona){
            paciente.mostrarDatos();
        }
    }
    
    public void pacienteGenero(){
        System.out.println("Digite el genero para listar los pacientes F/M");
        String genero = x.nextLine();
        for(Paciente paciente: ListaPersona){
            if(paciente.getGenero().equalsIgnoreCase(genero)){
                paciente.mostrarDatos();
            }
        }
                
    }
    
    //Busqueda de paciente
    public void buscarPaciente(int cedula){
        int sw = 0;
        for(Paciente paciente: ListaPersona){
            if(paciente.getnCedula() == cedula){
                sw = 1;
                paciente.mostrarDatos();
            }
            
            if(sw == 0){
                System.out.println("Paciente no registrado");
            }
        }
    }
}
