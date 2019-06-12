/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalgoritmos;

/**
 *
 * @author Kevin Trejos
 */
public class ShellSort {
    
    public static void shellSort(Persona[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)){
            for (int i = gap; i < a.length; i++) {
                Persona tmp = a[i];
                int j = i;
                for ( ; j >= gap && tmp.getCedula() < a[j - gap].getCedula(); j -= gap) {
                    a[j] = a[j - gap];
                    a[j] = tmp;
                }
            }
        }
    }
}
