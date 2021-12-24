/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controlador.OperacionesEmpleadoPOO;
import java.util.Scanner;
import modelo.Administrativo;
import modelo.Docente;
import modelo.Empleado;

/**
 *
 * @author kevin
 */
public class PrincipalEmpleadoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        OperacionesEmpleadoPOO obj = new OperacionesEmpleadoPOO();
        //instanciando los objetos polimorficos
        
        Empleado eDoc = new Docente();
        Empleado eAdm = new Administrativo();
        Scanner x = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        do{
            System.out.println("Menu de opciones");
            System.out.println("1. Registrar un docente");
            System.out.println("2. Registrar Administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Generar plantilla de sueldos");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion");
            opc = x.nextInt();
            switch(opc){
                case 1:
                    obj.registrarEmpleado(eDoc);
                    break;
                case 2:
                    obj.registrarEmpleado(eAdm);
                    break;
                case 3:
                    obj.mostrarEmpleado();
                    break;
                case 4:
                    obj.plantillaSueldo();
                    break;
                default:
                    continuar = false;
                    break;
            }
        }while(continuar);
    }
    
}
