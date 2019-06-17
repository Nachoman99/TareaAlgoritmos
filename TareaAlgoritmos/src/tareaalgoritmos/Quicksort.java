package tareaalgoritmos;

/**
 * En esta clase se implementa el método quicksort
 *
 * @author Jose Ignacio Zamora
 */
public class Quicksort {

    private static final int CUTOFF = 10;

    /**
     * Este método llama al quickSort privado
     *
     * @param lista vector a ordenar
     */
    public void quickSort(Persona[] lista) {
        quickSort(lista, 0, lista.length - 1);
    }

    /**
     * Este método cambia de posición a las Personas dentro del vector
     *
     * @param lista vector a ordenar
     * @param x una posición del vector
     * @param y una posición del vector
     */
    private void swapReferences(Persona[] lista, int x, int y) {
        Persona temp = lista[x];
        lista[x] = lista[y];
        lista[y] = temp;
    }

    /**
     * Este método va insertando ordenado dentro del vector
     *
     * @param lista vector a ordenar
     * @param low valor más bajo
     * @param high valor más alto
     */
    private void insertionSort(Persona[] lista, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Persona tmp = lista[i];
            int j;

            for (j = i; j > low && tmp.getCedula() < lista[j - 1].getCedula(); j--) {
                lista[j] = lista[j - 1];
            }
            lista[j] = tmp;
        }
    }

    /**
     * Va ordenando el vector
     *
     * @param lista vector a ordenar
     * @param low valor más bajo
     * @param high valor más alto
     */
    private void quickSort(Persona[] lista, int low, int high) {
        if (low + CUTOFF > high) {
            insertionSort(lista, low, high);
        } else {
            int middle = (low + high) / 2;
            if (lista[middle].getCedula() < lista[low].getCedula()) {
                swapReferences(lista, low, middle);
            }
            if (lista[high].getCedula() < lista[low].getCedula()) {
                swapReferences(lista, low, high);
            }
            if (lista[high].getCedula() < lista[middle].getCedula()) {
                swapReferences(lista, middle, high);
            }

            swapReferences(lista, middle, high - 1);
            Persona pivot = lista[high - 1];

            int i, j;
            for (i = low, j = high - 1;;) {
                while (lista[++i].getCedula() < pivot.getCedula())
          ;
                while (pivot.getCedula() < lista[--j].getCedula())
          ;
                if (i >= j) {
                    break;
                }
                swapReferences(lista, i, j);
            }
            swapReferences(lista, i, high - 1);

            quickSort(lista, low, i - 1);
            quickSort(lista, i + 1, high);
        }
    }
}
