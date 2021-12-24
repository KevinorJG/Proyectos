/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Administrativo;
import modelo.Docente;

/**
 *
 * @author kevin
 */
public class Operaciones {
    //definicin de listas
    List<Docente> listaDocente;
    List<Administrativo> listaAdministrativo;
    //constructor

    public Operaciones() {
        listaDocente = new ArrayList<>();
        listaAdministrativo = new ArrayList<>();
    }
    //registro de docente y la adicion a la lista correspondiente
    
    public void registrarDocente(){
        Docente docente = new Docente();
        docente.registrar();
        listaDocente.add(docente);
        System.out.println("Registro adicionado al personal");
    }
    
    public void mostrarDocente(){
        if(listaDocente !=null && listaDocente.size()>0){
            System.out.println("----LISTA DOCENTE----");
            for(Docente doc: listaDocente){
                doc.mostrar();
                System.out.println("--------------------");
            }
        }else{
            System.out.println("No tiene definido docente");
        }
    }
    
    //metodo de registro de Administrativo
    
    public void registrarAdministrativo(){
        Administrativo administrativo = new Administrativo();
        administrativo.registrar();
        listaAdministrativo.add(administrativo);
        System.out.println("Registro adicionado a los Administrativos");
    }
    
    public void mostrarAdministrativo(){
        if(listaAdministrativo !=null && listaAdministrativo.size() > 0 ){
            System.out.println(" ---LISTA ADMINISTRATIVO--- ");
            for(Administrativo adm: listaAdministrativo){
                adm.mostrar();
                System.out.println("----------------------");
            }
        }else{
            System.out.println("no tiene registro Administrativo en la lista");
        }
    }
    
    public void plantillaSueldo(){
        double bono, afp, liquidoPagable;
        double bonoAdm = 0, afpAdm, liquidoPagableAdm;
        if(listaDocente !=null && listaDocente.size() > 0){
            System.out.println("Nombre completo \t Salario Básico \t Bono antiguedad");
            for(Docente doc: listaDocente){
                long aa = doc.calculo();
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
                System.out.print(doc.getNombre()+"\t");
                System.out.print(doc.getSalarioBasico()+"\t");
                System.out.print(bono+"\t");
                System.out.print(afp+"\t");
                System.out.print(liquidoPagable+"\n");
            }
            if(listaAdministrativo !=null && listaAdministrativo.size() > 0){
                System.out.println("Nombre completo \t Salario Básico \t Bono antiguedad");
                for(Administrativo adm: listaAdministrativo){
                    long aaAdm = adm.calculo();
                    if(aaAdm <= 1){
                    bonoAdm = adm.getSalarioBasico() * 0;
                }else if(aaAdm >= 2 && aaAdm <=9){
                    bono = adm.getSalarioBasico() * 0.1;
                }else{
                    bono = adm.getSalarioBasico() * 0.3;
                }
                
                //calculo de afp
                afpAdm = adm.getSalarioBasico() * 1442;
                liquidoPagableAdm = (adm.getSalarioBasico() + bonoAdm) - afpAdm;
                System.out.print(adm.getNombre()+"\t");
                System.out.print(adm.getSalarioBasico()+"\t");
                System.out.print(bonoAdm+"\t");
                System.out.print(afpAdm+"\t");
                System.out.print(liquidoPagableAdm+"\n");
                    
                }
                
            }
        }
    }
    
            
    
}
