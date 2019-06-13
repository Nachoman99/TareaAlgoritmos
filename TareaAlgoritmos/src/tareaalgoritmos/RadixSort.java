/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalgoritmos;

import java.util.Arrays;

/**
 *
 * @author Kevin Trejos
 */
public class RadixSort {

     static Persona getMax(Persona[] arr) 
    { 
        Persona mx = arr[0]; 
        for (int i = 1; i < arr.length; i++) 
            if (arr[i].getCedula() > mx.getCedula()) 
                mx = arr[i]; 
        return mx; 
    } 
 
    static void countSort(Persona[] arr, int exp) 
    { 
        Persona[] output = new Persona[arr.length]; 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        for (i = 0; i < arr.length; i++) 
            count[ (arr[i].getCedula()/exp)%10 ]++; 

        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
        for (i = arr.length - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i].getCedula()/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i].getCedula()/exp)%10 ]--; 
        } 
        for (i = 0; i < arr.length; i++) 
            arr[i] = output[i]; 
    } 
    static void radixsort(Persona[] arr) 
    { 
        Persona m = getMax(arr);  
        for (int exp = 1; m.getCedula()/exp > 0; exp *= 10) 
            countSort(arr, exp); 
    } 
} 

