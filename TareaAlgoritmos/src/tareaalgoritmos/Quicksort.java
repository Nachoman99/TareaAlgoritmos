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
public class Quicksort {

    private static final int CUTOFF = 10;

    public static void quickSort(Persona[] lista) {
        quickSort(lista, 0, lista.length - 1);
    }

    private static void swapReferences(Persona[] lista, int x, int y) {
        Persona temp = lista[x];
        lista[x] = lista[y];
        lista[y] = temp;
    }

    private static void insertionSort(Persona[] lista, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Persona tmp = lista[i];
            int j;

            for (j = i; j > low && tmp.getCedula() < lista[j - 1].getCedula(); j--) {
                lista[j] = lista[j - 1];
            }
            lista[j] = tmp;
        }
    }

    private static void quickSort(Persona[] lista, int low, int high) {
        if (low + CUTOFF > high) {
            insertionSort(lista, low, high);
        } else {
            int middle = (low + high) / 2;
            if (lista[middle].getCedula() < lista[low].getCedula()) {
                swapReferences(lista, low, middle);
            }
            if (lista[high].getCedula()< lista[low].getCedula()) {
                swapReferences(lista, low, high);
            }
            if (lista[high].getCedula()<lista[middle].getCedula()) {
                swapReferences(lista, middle, high);
            }

            swapReferences(lista, middle, high - 1);
            Persona pivot = lista[high - 1];

            int i, j;
            for (i = low, j = high - 1;;) {
                while (lista[++i].getCedula()<pivot.getCedula())
          ;
                while (pivot.getCedula()< lista[--j].getCedula())
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
    
    public void printArray(Persona[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\n");
        }
        System.out.println(")");
    }
}
