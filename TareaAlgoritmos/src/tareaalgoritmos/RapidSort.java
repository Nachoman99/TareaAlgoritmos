/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalgoritmos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Kevin Trejos
 */
public class RapidSort {

    public Persona[] radixSort(Persona[] unsorted) {
        // Create a box with 10 buckets.
        Queue[] box = new Queue[unsorted.length];
        for (int i = 0; i < box.length; i++) {
            box[i] = new LinkedList<Integer>();
        }

//        System.out.print("Unsorted list:   ");
//        printArray(unsorted);
        // Find the longest number in the unsorted array.
        int length = 0;
        for (int i = 0; i < unsorted.length; i++) {
            int n = (int) (Math.log10(unsorted[i].getCedula()) + 1);
            if (n > length) {
                length = n;
            }
        }

        int m = 10; // The number to use modulo on
        int n = 1; // The number for rounding division.
        // Repeats as long as the highest number in the array.
        for (int i = 0; i < length; i++) {

            // Perform calculation and put element in correct bucket.
            for (int y = 0; y < unsorted.length; y++) {
                int nbr = (unsorted[y].getCedula() % m) / n;
                box[nbr].add(unsorted[y]);
            }

            // Now remove the numbers in order and put them in a new array.
            int x = 0;
            for (int j = 0; j < box.length; j++) {
                while (!box[j].isEmpty()) {
                    unsorted[x] = (Persona) box[j].remove();
                    x++;
                }
            }
//            System.out.print("Partly Sorted " + n + "'s: (");
//            printArray(unsorted);
            m *= 10;
            n *= 10;
        }
//        System.out.print("Sorting complete: ");
//        printArray(unsorted);
        return unsorted;
    }
}
