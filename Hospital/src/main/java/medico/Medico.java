package medico;

import java.util.ArrayList;

/**
 *
 * @author Kevin Ortiz
 */
public class Medico {
    
    private String Carnet;
    private String Nombre;
    private String apellidos;
    private String Genero;
    private String Horario;
    private String LugarDeOficio;
    private ArrayList<String> ListaMedicos;
    
    //constructor

    public Medico() { 
        ListaMedicos = new ArrayList<>();
    }
    
    //metodos
    
    
     
    
    //getter y setter

    public String getCarnet() {
        return Carnet;
    }

    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getLugarDeOficio() {
        return LugarDeOficio;
    }

    public void setLugarDeOficio(String LugarDeOficio) {
        this.LugarDeOficio = LugarDeOficio;
    }


    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


}
