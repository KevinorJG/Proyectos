package Clases;
import java.util.Scanner;
import javax.swing.JOptionPane;

public abstract class Atributos {
    public static Scanner entrada = new Scanner(System.in);
    
    protected int transacciones;
    protected int retiro;
    protected int deposito;
    
    private static int saldo;

    public static int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void Operations(){
        int bandera = 0;
        int seleccion = 0;
       
    do{
        
        do{
            
            System.out.println("\nPorfavor seleccione una opción:");
            System.out.println("-------------------------------");
            System.out.println("    1. Consulta de saldo.");
            System.out.println("    2. Retiro de efectivo.");
            System.out.println("    3. Deposito de efectivo.");
            System.out.println("    4. Salir.");
            System.out.println("-------------------------------");
            System.out.println("Ingrese una opción: ");
            seleccion = entrada.nextInt();
           
           if(seleccion >= 1 && seleccion <= 4){
              bandera = 1;
           }else{
               System.err.println("Opcion no disponible, intente de nuevo");
           }
                    
        }while(bandera == 0);
        
        if(seleccion == 1){
            Atributos llamar = new Consulta();
            llamar.Transaccion();
            
        }else if(seleccion == 2){
            Atributos llamar = new Retiro();
            llamar.Transaccion();
        }else if(seleccion == 3){
            Atributos llamar = new Deposito();
            llamar.Transaccion();
            
        }else if(seleccion == 4){
            JOptionPane.showMessageDialog(null, "¡Vuelva pronto!");
            bandera = 2;
        }
        
    }while(bandera != 2);
    
    }
   
    //Solicitar cantidad
    public void Retiro(){
        retiro = entrada.nextInt();
        
    }
    
   //solicitar deposito
    public void Deposito(){
        deposito = entrada.nextInt();
    }
    
    public abstract void Transaccion();
    
    
}
