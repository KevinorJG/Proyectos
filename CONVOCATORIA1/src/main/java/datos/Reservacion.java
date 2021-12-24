package datos;

/**
 *
 * @author kevin
 */
public class Reservacion {
    private String modelo;
    private String marca;
    private String color;
    private String matricula;
    private Boolean disponible;

    public Reservacion(String modelo, String marca, String color, String matricula) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public Reservacion() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    
    public void Alquiler(){
        
    }
}
