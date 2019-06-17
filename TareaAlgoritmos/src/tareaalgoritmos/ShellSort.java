package tareaalgoritmos;

/**
 * En esta clase se implementa el método shellsort
 * @author Kevin Trejos
 */
public class ShellSort {

    /**
     * Este método ordena un vector de Personas por número de cédula
     * @param vector Vector vector ordenar
     */
    public void shellSort(Persona[] vector) {
        for (int gap = vector.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < vector.length; i++) {
                Persona tmp = vector[i];
                int j = i;
                for (; j >= gap && tmp.getCedula() < vector[j - gap].getCedula(); j -= gap) {
                    vector[j] = vector[j - gap];
                }
                vector[j] = tmp;
            }
        }
    }
}
