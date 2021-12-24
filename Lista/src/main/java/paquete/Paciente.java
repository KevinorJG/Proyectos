package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {

    Scanner x = new Scanner(System.in);

    private int nCedula;
    private String paterno;
    private String materno;
    private String nombre;
    private String genero;
    private String fechaNacimiento;
    private ArrayList<String> ListaPersona;

    //atributo no propio de la clase
    private String ubicacionInter;

    //constructores
    public Paciente() {

        ListaPersona = new ArrayList<>();
    }

    //metodos
    public void llenarDatos() {
        String res = "S";
        
        System.out.println("------Registro de paciente------\n");
        System.out.println("Número de cédula: ");
        this.nCedula = x.nextInt();
        //limpiado de buffer
        x.nextLine();

        System.out.println("Apellido Paterno: ");
        this.paterno = x.nextLine();
        System.out.println("Apellido Materno: ");
        this.materno = x.nextLine();
        System.out.println("Su nombre: ");
        this.nombre = x.nextLine();
        System.out.println("Ingrese su género F/M");
        this.genero = x.nextLine();
        System.out.println("Digite su fecha de nacimiento en el siguiente orden\n dia/mes/año: ");
        this.fechaNacimiento = x.nextLine();

        System.out.println("Nombre de hospital en el que será internado");
        this.ubicacionInter = x.nextLine();
        System.out.println("------SINTOMAS------");
        
        do {
            System.out.println("Sintoma del paciente:");
            ListaPersona.add(x.nextLine());
            System.out.println("Desea añadir otro sintoma S/N");
            res = x.nextLine();
        } while (res.equalsIgnoreCase("S"));

    }

    public void sintomas() {
        System.out.println("Sintoma del paciente:");
        ListaPersona.add(x.nextLine());
    }

    public void mostrarDatos() {
        System.out.println("# Cédula: " + this.nCedula);
        System.out.println("Apellido paterno: " + this.paterno);
        System.out.println("Apellido materno: " + this.materno);
        System.out.println("Género: " + this.genero);
        System.out.println("Fecha de Nacimientpo: " + this.fechaNacimiento);
        System.out.println("Hospital de internación: " + this.ubicacionInter);
        System.out.println("-----SINTOMAS-----");
        for (String s : ListaPersona) {
            System.out.println("" + s);
        }
    }
    

    //getters and setters
    public int getnCedula() {
        return nCedula;
    }

    public void setnCedula(int nCedula) {
        this.nCedula = nCedula;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUbicacionInter() {
        return ubicacionInter;
    }

    public void setUbicacionInter(String ubicacionInter) {
        this.ubicacionInter = ubicacionInter;
    }

}
