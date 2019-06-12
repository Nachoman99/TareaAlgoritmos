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
public class Mergesort {
    public static void mergeSort(Persona[] lista){
        Persona[] temp =new Persona[lista.length];
        mergeSort(lista,temp,0,lista.length-1);
    }
    
    private static void mergeSort(Persona[] lista, 
            Persona[] temp,int left,int right){
        if(left<right){
            int center =(left+right)/2;
            mergeSort(lista, temp, left, center);
            mergeSort(lista, temp, center+1, right);
            mergeSort(lista, temp, left, center+1,right);
        }
    }
    
    private static void mergeSort(Persona[] lista, 
            Persona[] temp,int leftPos,int rightPos, int rightEnd){
        int leftEnd=rightPos-1;
        int tmpPos=leftPos;
        int numElements= rightEnd-leftPos+1;
        
        while (leftPos<=leftEnd&&rightPos<=rightEnd) {
            if(lista[leftPos].getCedula()<=lista[rightPos].getCedula()){
                temp[tmpPos++]=lista[leftPos++];
            }else{
                temp[tmpPos++]=lista[rightPos++];
            }
            
        }
        while(leftPos<=leftEnd){
            temp[tmpPos++]=lista[leftPos++];
        }
        while (rightPos<=rightEnd) {            
            temp[tmpPos++]=lista[rightPos++];
        }
        
        for (int i = 0; i < numElements; i++,rightEnd--) {
            lista[rightEnd]=temp[rightEnd];
        }
        
        
    }
    
     public void printArray(Persona[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\n");
        }
        System.out.println(")");
    }
    
}
