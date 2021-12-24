package Clases;

import javax.swing.JOptionPane;

public class Consulta extends Atributos{
 
    @Override
    public void Transaccion(){
        System.out.println("* ACCION EJECUTADA *");
        JOptionPane.showMessageDialog(null, "Tu saldo actual es: "+getSaldo());
        
    }
    
}
