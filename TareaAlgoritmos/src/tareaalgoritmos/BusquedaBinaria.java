/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalgoritmos;

/**
 *
 * @author Nacho
 */
public class BusquedaBinaria {

    public static Persona busquedaBinaria(Persona[] vector, int dato) {
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
