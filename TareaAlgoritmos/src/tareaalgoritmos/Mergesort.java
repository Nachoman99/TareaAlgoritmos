package tareaalgoritmos;

/**
 * En esta clase se implementa el mergesort
 *
 * @author Jose Ignacio Zamora
 */
public class Mergesort {

    /**
     * Este metodo llama a otros métodos privados que ordenan el vector
     *
     * @param lista vector a ordenar
     */
    public void mergeSort(Persona[] lista) {
        Persona[] temp = new Persona[lista.length];
        mergeSort(lista, temp, 0, lista.length - 1);
    }

    /**
     * Toma el valor central del vector para dàrselo a otros mètodos
     *
     * @param lista vector a ordenar
     * @param temp vector temporal
     * @param left valor a la izquierda
     * @param right valor a la derecha
     */
    private void mergeSort(Persona[] lista,
            Persona[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(lista, temp, left, center);
            mergeSort(lista, temp, center + 1, right);
            mergeSort(lista, temp, left, center + 1, right);
        }
    }

    /**
     * Este método va ordenando el vector
     *
     * @param lista vector a ordenar
     * @param temp vector temporal
     * @param leftPos valor a la izquierda en el vector
     * @param rightPos valor a la derecha en el vector
     * @param rightEnd valor final a la derecha
     */
    private void mergeSort(Persona[] lista,
            Persona[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (lista[leftPos].getCedula() <= lista[rightPos].getCedula()) {
                temp[tmpPos++] = lista[leftPos++];
            } else {
                temp[tmpPos++] = lista[rightPos++];
            }

        }
        while (leftPos <= leftEnd) {
            temp[tmpPos++] = lista[leftPos++];
        }
        while (rightPos <= rightEnd) {
            temp[tmpPos++] = lista[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            lista[rightEnd] = temp[rightEnd];
        }
    }
}
