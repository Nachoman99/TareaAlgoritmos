package tareaalgoritmos;

/**
 * En esta clase se implementa el método de busqueda binaria
 *
 * @author Kevin Trejos
 */
public class BusquedaBinaria {

    /**
     * Este método es el de busqueda binaria
     *
     * @param vector Un vector de personas
     * @param dato numero de cédula a buscar
     * @return La persona con el número de cédula encontrado, null si no
     * encuentra la persona asociada a ese número de cédula
     */
    public Persona busquedaBinaria(Persona[] vector, int dato) {
        int n = vector.length;
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (vector[centro].getCedula() == dato) {
                return vector[centro];
            } else if (dato < vector[centro].getCedula()) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return null;
    }
}
