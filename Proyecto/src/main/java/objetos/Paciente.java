package objetos;

/**
 *
 * @author kevin
 */
public class Paciente {

    //Atributos de la clase
    private String nCedula;
    private String paterno;
    private String materno;
    private String nombre;
    private String genero;
    private String fechaNacimiento;
    private String ubicacionInter;
    //-----------------------------

    //constructor con datos
    public Paciente(String nCedula, String paterno, String materno, String nombre, String genero, String fechaNacimiento, String ubicacionInter) {
        this.nCedula = nCedula;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre  = nombre;
        this.genero  = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ubicacionInter  = ubicacionInter;
    }

    //constructor vacio
    public Paciente() {

    }

    //getters and setters
    public String getnCedula() {
        return nCedula;
    }

    public void setnCedula(String nCedula) {
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
