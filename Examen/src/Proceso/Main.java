package Proceso;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Operation_person obj = new Operation_person();
        int opc;
        boolean cont = true;
        do {
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("1-Registrar Usuario");
            System.out.println("2-Mostrar Usuarios");
            System.out.println("3-Crear Automovil");
            System.out.println("4-Mostrar Automovil");
            System.out.println("5-Asignar Automovil");
            System.out.println("6-Registrar una Boleta De Infraccion");
            System.out.println("7-Pagar Boleta De Infraccion");
            System.out.println("8-Ajustar Boleta de infraccion");
            System.out.println("9-Salir");
            System.out.println("Ingrese una Opcion.");

            opc = s.nextInt();
            switch (opc) {
                case 1:
                    obj.Registro_Usuario();
                    break;

                case 2:
                    obj.Mostrar_Usuario();
                    break;

                case 3:
                    obj.Registrar_Automovil();
                    break;

                case 4:
                    obj.Mostrar_Automovil();
                    break;

                case 5:
                    obj.Asignar_automovil();
                    break;

                case 6:

                    obj.BoletaInfraccion();
                    break;

                case 7:
                    System.out.println("Digite el Nro. de Boleta que desea cancelar: ");
                    int nb = s.nextInt();
                    obj.Pagar_Bol_Infrac(nb);
                    break;
                case 8:
                	obj.AjustarBoleta();
                	break;

                default:
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
