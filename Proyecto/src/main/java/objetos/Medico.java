
package objetos;

public class Medico {
    private String carnet;
    private String nombrem;
    private String genero;
    private String hospitalDeTrabajo;
    private String horario;
    
    //Constructor con datos
    public Medico(String carnet, String nombre, String genero, String hospitalDeTrabajo, String horario) {
        this.carnet = carnet;
        this.nombrem = nombre;
        this.genero = genero;
        this.hospitalDeTrabajo = hospitalDeTrabajo;
        this.horario = horario;
    }
    
    //Constructor vacio
    public Medico() {
    }
    
    // Getters y setters
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombrem() {
        return nombrem;
    }

    public void setNombrem(String nombre) {
        this.nombrem = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHospitalDeTrabajo() {
        return hospitalDeTrabajo;
    }

    public void setHospitalDeTrabajo(String hospitalDeTrabajo) {
        this.hospitalDeTrabajo = hospitalDeTrabajo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
    
}
