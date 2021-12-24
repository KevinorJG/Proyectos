/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;

/**
 *
 * @author kevin ortiz
 */
public class Docente extends Empleado{ 
    //atributos
    private int nroCedula;
    private String titulo;
    private String nivel;
    private String area;
    private int cargaHoraria;
    Scanner x = new Scanner(System.in);
    //constructores
    //metodos propios, metodos sobreescritos
    @Override
    public void registrar(){
        //llamado de metodos de la superclase
        super.registrar();
        System.out.println("Registro de docente...\n");
        System.out.println("Titulo de docente");
        this.titulo = x.nextLine();
        System.out.println("Nivel de trabajo");
        this.nivel = x.nextLine();
        System.out.println("Area de trabajo");
        this.area = x.nextLine();
        System.out.println("Carga horaria");
        this.cargaHoraria = x.nextInt();
        System.out.println("Docente Registrado");
        
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Nivel: "+this.nivel);
        System.out.println("Area laboral: "+this.area);
        System.out.println("Carga horaria: "+this.cargaHoraria);
    }
    
    /*@Override
    public long calculo(){
        long aa = super.calculo();
        return aa;
    }*/
    
    //getters and setters

    public int getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(int nroCedula) {
        this.nroCedula = nroCedula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
}
