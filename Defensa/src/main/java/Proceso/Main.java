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
            System.out.println("3-Registrar una Boleta De Infraccion");
            System.out.println("4-Pagar Boleta De Infraccion");
            System.out.println("5-Ajustar Boleta de infraccion");
            System.out.println("6-Salir");
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
                    obj.BoletaInfraccion();
                    break;

                case 4:
                    System.out.println("Digite el Nro. de Boleta que desea cancelar: ");
                    int nb = s.nextInt();
                    obj.Pagar_Bol_Infrac(nb);
                    
                    break;

                case 5:
                    obj.AjustarBoleta();
                   
                    break;

                case 6:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
