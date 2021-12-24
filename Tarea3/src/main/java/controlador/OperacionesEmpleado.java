/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Docente;
import modelo.Administrativo;

/**
 *
 * @author kevin ortiz
 */
public class OperacionesEmpleado {
    
    List<Docente> listaDocente;
    List<Administrativo> listaAdimistrativo;

    public OperacionesEmpleado() {
        listaDocente = new ArrayList<>();
    }
    
    //metodos
    public void registroDocente(int nCedula, String nombreCompleto, String fingreso, double salarioBasico, 
                String titulo, String nivel, String area, int cargaHoraria){
        //
        Docente docente = new Docente();
        docente.setNroCedula(nCedula);
        docente.setNombre(nombreCompleto);
        docente.setFechaIngreso(fingreso);
        docente.setSalarioBasico(salarioBasico);
        docente.setTitulo(titulo);
        docente.setNivel(nivel);
        docente.setArea(area);
        docente.setCargaHoraria(cargaHoraria);
        //adiciona a la lista
        
        listaDocente.add(docente);
        System.out.println("Registro correcto de Docente");
        System.out.println(listaDocente.toString());
        
    }
    
    public Docente buscarDocente(int nCedula){
        Docente dAux = new Docente();
        int sw = 0;
        if(listaDocente != null && listaDocente.size() > 0){
            for(Docente doc: listaDocente){
                if(doc.getNroCedula()==nCedula){
                    sw = 1;
                    dAux = doc;
                    System.out.println("Docente encontrado");
                }
            }
        }
        if(sw == 0){
            dAux = null;
            System.out.println("Docente no encontrado");
        }
        return dAux;
    }
    //getters and setters 

    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public void setListaDocente(List<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }
    
    
    
}
