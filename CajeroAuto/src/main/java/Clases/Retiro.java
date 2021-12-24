package Clases;

import javax.swing.JOptionPane;

public class Retiro extends Atributos{
    
   @Override
    public void Transaccion(){
        System.out.println("¿Cuanto desea retirar?");
        Retiro();
          
        if(retiro <= getSaldo()){
            transacciones = getSaldo();
            setSaldo(transacciones - retiro);
            System.out.println("-------------------------------");
            System.out.println("Retiraste: "+retiro);
            System.out.println("Tu saldo actual es: "+getSaldo());
            System.out.println("-------------------------------");
                    
        }else{
            System.out.println("* ACCION EJECUTADA *");
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }
    }
    
}
