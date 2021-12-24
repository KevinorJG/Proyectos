package Clases;

public class Main {

    
    public static void main(String[] args) {
       
        //Genera una cantidad, simulando el pago del usuario
        int saldoAleatorio = (int) (Math.random()*5000+1000);
        
        Atributos conectar = new Consulta();
        conectar.setSaldo(saldoAleatorio);
        conectar.Operations();
        
    }
    
}
