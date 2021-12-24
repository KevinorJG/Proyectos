/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author kevin ortiz
 */
public class Empleado {
    
   //atributos
    private int nroCedula;
    private String nombre;
    private String fechaIngreso;
    private double salarioBasico;
    Scanner x = new Scanner(System.in);
    //constructores
    //metodos
    public void registrar(){
        System.out.println("Ingrese los siguientes datos\n");
        System.out.println("Número de cédula");
        this.nroCedula = x.nextInt();
        System.out.println("Nombre completo");
        this.nombre = x.nextLine();
        System.out.println("Fecha de ingreso");
        this.fechaIngreso = x.nextLine();
        System.out.println("dd/mm/aaaa");
        this.fechaIngreso = x.nextLine();
        System.out.println("Salario básico");
        this.salarioBasico = x.nextDouble();
        System.out.println("Registro completado");      
    }
    
    public void mostrar(){
        System.out.println("Cédula: "+this.nroCedula);
        System.out.println("Nombre completo: "+this.nombre);
        System.out.println("Fecha de ingreso: "+this.fechaIngreso);
        System.out.println("Salario básico: "+this.salarioBasico);
                
    }
    
    public long calculo(){
        LocalDate fechaActual = LocalDate.now(); //obtiene la fecha actual 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //convierte el formato a la fecha ingresada
        LocalDate fechaInicial = LocalDate.parse(this.fechaIngreso,format);//parsea la fecha de ingreso a localDate
        long a = ChronoUnit.YEARS.between(fechaInicial, fechaActual); //obtiene la diferencia de años
        return a;
        
        
    }
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public int getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(int nroCedula) {
        this.nroCedula = nroCedula;
    }
    
    
}
