/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalgoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class TareaAlgoritmos {

    private static Properties propertie = new Properties();
    private static FileOutputStream output;
    private static FileInputStream input;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Persona> lista = new ArrayList<>();
        boolean salir = false;
        String ruta = "";
        Persona[] vector = new Persona[1000000];
        
        while (!salir) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite una de las siguientes opciones: \n"
                    + "1) Cargar archivo.\n"
                    + "2) Ordenar con Shellsort.\n"
                    + "3) Ordenar con Mergesort.\n"
                    + "4) Ordenar con Radixsort.\n"
                    + "5) Ordenar con Quicksort.\n"
                    + "6) Buscar una persona. \n"
                    + "7) Imprimir.\n"
                    + "8) Salir."));
            switch (opcion) {
                case 1:
                    ruta = "";
                    JFileChooser file = new JFileChooser();
                    file.showOpenDialog(file);
                    File fichero = file.getSelectedFile();
                    try {
                        lista = leerArchivo(fichero.getPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    ShellSort sort = new ShellSort();
                    vector = (Persona[]) lista.toArray();
                    sort.shellSort(vector);
                    break;
                case 3:
                    Mergesort sortM = new Mergesort();
                    vector = (Persona[]) lista.toArray();
                    sortM.mergeSort(vector);
                    
                    break;
                case 4:
                    RapidSort sortR = new RapidSort();
                    vector = (Persona[]) lista.toArray();
                    
                    break;
                case 5:
                    Quicksort sortQ = new Quicksort();
                    vector = (Persona[]) lista.toArray();
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    printArray(vector);
                    break;
                case 8:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Hasta pronto");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite una opción válida");
                    break;
            }
        }

    }

    public static ArrayList leerArchivo(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Persona> list = new ArrayList<>();
        File file = new File(ruta);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = "";
        String[] parts;
        int cedula = 0;
        String nombre = "";
        int edad = 0;
        while ((str = br.readLine()) != null) {
            parts = str.split(",");
            cedula = Integer.parseInt(parts[0]);
            nombre = parts[1];
            edad = Integer.parseInt(parts[2]);
            Persona persona = new Persona(cedula, nombre, edad);
            list.add(persona);
        }
        return list;
    }

    //            Quicksort quick = new Quicksort();
//            Mergesort merge = new Mergesort();
//        RapidSort sort = new RapidSort();
//        Persona[] vc = new Persona[200000];
//        Persona[] ordenado = new Persona[200000];
//        try {
//            ArrayList<Persona> list = leerArchivo();
//            for (int i = 0; i < list.size(); i++) {
//                vc[i] = list.get(i);
//            }
//            merge.mergeSort(vc);
//            //quick.quickSort(vc);
//            //ordenado = sort.radixSort(vc);
//            sort.printArray(vc);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    
    public static void printArray(Persona[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " \n ");
        }
        System.out.println(")");
    }
}
