package datos;
//import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kevin
 */
public class Cliente{
    Scanner x = new Scanner(System.in);
    private String ID;
    private String datos;
    private String Direccion;
    private int telefono;
    
    public Cliente(String ID, String datos, String Direccion, int telefono) {
        this.ID = ID;
        this.datos = datos;
        this.Direccion = Direccion;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void Reservacion(){
        System.out.println("ID de usuario");
        this.ID = x.nextLine();
        System.out.println("Datos bancarios");
        this.datos = x.nextLine();
        System.out.println("Direccion");
        this.Direccion = x.nextLine();
        System.out.println("Telefono");
        this.telefono = x.nextInt();   
    }
    public void mostrar(){
        System.out.println("ID de usuario "+this.ID);
        System.out.println("Datos bancarios "+this.datos);
        System.out.println("Direccion "+this.Direccion);
        System.out.println("Telefono "+this.telefono);
    }
    
    
}
