package paquete;

import java.util.Scanner;


public class PrincipalPaciente {

    public static void main(String[] args) {
        boolean continuar = true;
        Scanner x  = new Scanner(System.in);
        int opcion = 0;
        //Instancia de objetos
        OperacionesPaciente conectar = new OperacionesPaciente();
       

        do{
            System.out.println("Menu de opciones");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Listado por Género");
            System.out.println("4. Buscar Paciente");
            System.out.println("5. Salir");
            System.out.println("Digite una opcion");
            opcion = x.nextInt();
            
            switch(opcion){
                case 1:
                    conectar.registrarPaciente();
                    break;
                case 2: 
                    conectar.ListadoDePaciente();
                    break;
                case 3:
                    conectar.pacienteGenero();
                case 4:
                    System.out.println("Ingrese el número de cédula");
                    int nc = x.nextInt();
                    conectar.buscarPaciente(nc);
                    break;
                default:
                    continuar = false;
                    break;
            }
                    
        }while(continuar);
    }
    
}
