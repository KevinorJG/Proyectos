/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Administrativo;
import modelo.Docente;
import modelo.Empleado;

/**
 *
 * @author kevin
 */
public class OperacionesEmpleadoPOO {
    
    List<Empleado> listaEmpleado;

    public OperacionesEmpleadoPOO() {
        listaEmpleado = new ArrayList<>();
    }
    
    public void registrarEmpleado(Empleado emp){
        
        if(listaEmpleado != null){
            if(emp instanceof Docente){
                Docente doc = new Docente();
                doc.registrar();
                listaEmpleado.add(doc);
                System.out.println("Docente registrado");
            }
            else{
                if(emp instanceof Administrativo){
                   // Administrativo adm = (Administrativo)emp;
                   Administrativo adm = new Administrativo();
                    adm.registrar();
                    listaEmpleado.add(adm);
                    System.out.println("Administrativo registrado");
                }
            }
        }
    }
    
    public void mostrarEmpleado(){
        if(listaEmpleado != null && listaEmpleado.size() > 0){
            System.out.println("----Lista empleados----");
            for(Empleado e: listaEmpleado){
                if(e instanceof Docente){
                    Docente doc = (Docente)e;
                    doc.mostrar();
                }else{
                    if(e instanceof Administrativo){
                        Administrativo adm = (Administrativo)e;
                        adm.mostrar();
                    }
                }
                System.out.println("-------------*---------------");
            }
        }
    }
    //generacion de la plantilla de sueldos
    public void plantillaSueldo(){
        double bono, afp, liquidoPagable; int c=1;
        double bonoAdm = 0, afpAdm, liquidoPagableAdm;
        if(listaEmpleado !=null && listaEmpleado.size() > 0){
            System.out.println("\t\t-------PLANTILLA DE SUELDO-------");
            System.out.println("Nro. \t NombreCompleto"+"\t Salario Básico"+"\t Bono"+"\t AFP"+"\t Salario Liquido");
            for(Empleado e: listaEmpleado){
                long aa = e.calculo();
                if(e instanceof Docente){
                    Docente doc = (Docente)e;
                    if(aa <= 1){
                    bono = doc.getSalarioBasico() * 0;
                }else if(aa >= 2 && aa <=9){
                    bono = doc.getSalarioBasico() * 0.3;
                }else{
                    bono = doc.getSalarioBasico() * 0.5;
                }
                
                //calculo de afp
                afp = doc.getSalarioBasico() * 1442;
                liquidoPagable = (doc.getSalarioBasico() + bono) - afp;
                System.out.print(c+"\t"+doc.getNombre()+"\t");
                System.out.print(doc.getSalarioBasico()+"\t");
                System.out.print(bono+"\t");
                System.out.print(afp+"\t");
                System.out.print(liquidoPagable+"\n");
                }else{
                    //casteo de objeto empleado e a Administrativo
                    Administrativo adm = (Administrativo)e;
                    if(aa <= 1){
                    bonoAdm = adm.getSalarioBasico() * 0;
                }else if(aa >= 2 && aa <=9){
                    bono = adm.getSalarioBasico() * 0.1;
                }else{
                    bono = adm.getSalarioBasico() * 0.3;
                }
                
                //calculo de afp
                afpAdm = adm.getSalarioBasico() * 1442;
                liquidoPagableAdm = (adm.getSalarioBasico() + bonoAdm) - afpAdm;
                System.out.print(c+"\t"+adm.getNombre()+"\t");
                System.out.print(adm.getSalarioBasico()+"\t");
                System.out.print(bonoAdm+"\t");
                System.out.print(afpAdm+"\t");
                System.out.print(liquidoPagableAdm+"\n");
                }
                
                
            }
        }
    }
    
}
