package objetos;

/**
 *
 * @author kevin
 */
public class Asignados {
    private String nombreP;
    private String nombreM;
    private String cedula;
    private String carnet;
    private int sala;
    
    public Asignados(String cedula, String carnet, String nombreP, String nombreM, int sala) {
        this.cedula = cedula;
        this.carnet = carnet;
        this.nombreP = nombreP;
        this.nombreM = nombreM;
        this.sala = sala;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    
    
    
    
}
