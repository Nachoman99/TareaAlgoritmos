package tareaalgoritmos;

/**
 * En esta clase se representa a una Persona
 *
 * @author Jose Ignacio Zamora
 */
public class Persona {

    private int cedula;
    private String nombre;
    private int edad;

    /**
     * Constructor
     */
    public Persona() {
    }

    /**
     * Constructor
     *
     * @param cedula cedula de la persona
     * @param nombre de la Persona
     * @param edad de la Persona
     */
    public Persona(int cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Get
     *
     * @return la cédula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Set
     *
     * @param cedula Envía la cédula
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Get
     *
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set
     *
     * @param nombre a enviarle a la Persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get
     *
     * @return la edad de la Persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set
     *
     * @param edad la edad a enviarle
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * toString
     *
     * @return los datos de la Persona
     */
    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

}
