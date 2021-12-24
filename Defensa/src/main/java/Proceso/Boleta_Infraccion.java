package Proceso;

import java.util.Scanner;

public class Boleta_Infraccion {

    Scanner s = new Scanner(System.in);

    private int NroBoleta;
    private String NombConduc;
    private String Fecha;
    private String lugar;
    private String Tipo_Infrac;
    private int Costo;
    private String Estado;

    public void Llenar_Infraccion() {
        System.out.println("Digite el Nro. de Boleta: ");
        this.NroBoleta = s.nextInt();
        System.out.println("Nombre del conductor Infraccionado: ");
        this.NombConduc = s.nextLine();
        //Limpiar buffer
        s.nextLine();
        System.out.println("");
        System.out.println("Digite la Fecha de la infraccion (dd/mm/aaaa): ");
        this.Fecha = s.nextLine();
        System.out.println("Digite el lugar de la infraccion: ");
        this.lugar = s.nextLine();
        System.out.println("Digite el tipo de infraccion: ");
        this.Tipo_Infrac = s.nextLine();
        System.out.println("Digite el costo de la infraccion: ");
        this.Costo = s.nextInt();
        this.Estado = "EMITIDO";
        System.out.println("---BOLETA DE INFRACCION REGISTRADA---");
    }

    public void Mostrar_Boleta() {
        System.out.println("-----------------------------------------------");
        System.out.println("Nro. de Boleta: " + this.NroBoleta);
        System.out.println("Nombre del Conductor: " + this.NombConduc);
        System.out.println("Fecha: " + this.Fecha);
        System.out.println("Lugar: " + this.lugar);
        System.out.println("Infraccion: " + this.Tipo_Infrac);
        System.out.println("Costo: " + this.Costo);
        System.out.println("Estado: " + this.Estado);
        System.out.println("-----------------------------------------------");
    }

    //Getters y Setters
    public int getNroBoleta() {
        return NroBoleta;
    }

    public String getNombConduc() {
        return NombConduc;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getTipo_Infrac() {
        return Tipo_Infrac;
    }

    public int getCosto() {
        return Costo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setNroBoleta(int NroBoleta) {
        this.NroBoleta = NroBoleta;
    }

    public void setNombConduc(String NombConduc) {
        this.NombConduc = NombConduc;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setTipo_Infrac(String Tipo_Infrac) {
        this.Tipo_Infrac = Tipo_Infrac;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
