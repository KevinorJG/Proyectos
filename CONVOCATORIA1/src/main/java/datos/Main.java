package datos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Main {

    public static Scanner x = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ID;
        String datos;
        String Direccion;
        int telefono;
        boolean res = true;
        Cliente obj = new Cliente();

        ArrayList<Reservacion> lista = new ArrayList<>();
        int opcion;

        do {
            System.out.println("¿Desea realizar una reservacion?");
            opcion = x.nextInt();
            switch (opcion = 1) {
                case 1:
                    obj.Reservacion();
                    obj.mostrar();
                    break;
                case 2:
                    
                    
            }
        } while (res);

    }

}
