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
        Persona[] vector = null;
        boolean ordenado = false;
        boolean archivoCargado = false;
        long inicio;
        long fin;
        long tiempo;
//        Persona[] vectorRadix;
//        Persona[] vectorMerge;
//        Persona[] vectorQuick;

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
                    ordenado = false;
                    archivoCargado = false;
                    ruta = "";
                    JFileChooser file = new JFileChooser();
                    file.showOpenDialog(file);
                    File fichero = file.getSelectedFile();
                    try {
                        lista = leerArchivo(fichero.getPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    archivoCargado = true;
                    break;
                case 2:
                    if (archivoCargado && !ordenado) {
                        vector = new Persona[lista.size()];
                        ShellSort sort = new ShellSort();
                        vector = (Persona[]) lista.toArray(vector);
                        inicio = System.currentTimeMillis();
                        sort.shellSort(vector);
                        fin = System.currentTimeMillis();
                        tiempo = fin - inicio;
                        ordenado = true;
                        JOptionPane.showMessageDialog(null, "El método shellsort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenado) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada, por favor cargue otra");
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor cargue un archivo antes de ordenar");
                            ordenado = false;
                        }
                    }
                    break;
                case 3:
                    if (archivoCargado && !ordenado) {
                        vector = new Persona[lista.size()];
                        Mergesort sortM = new Mergesort();
                        vector = (Persona[]) lista.toArray(vector);
                        inicio = System.currentTimeMillis();
                        sortM.mergeSort(vector);
                        fin = System.currentTimeMillis();
                        ordenado = true;
                        tiempo = fin - inicio;
                        JOptionPane.showMessageDialog(null, "El método mergeSort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenado) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada, por favor cargue otra");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cargue un archivo antes de ordenarlo");
                            ordenado = false;
                        }
                    }
                    break;
                case 4:
                    if (archivoCargado && !ordenado) {
                        vector = new Persona[lista.size()];
                        RapidSort sortR = new RapidSort();
                        vector = (Persona[]) lista.toArray(vector);
                        inicio = System.currentTimeMillis();
                        sortR.radixSort(vector);
                        fin = System.currentTimeMillis();
                        ordenado = true;
                        tiempo = fin - inicio;
                        JOptionPane.showMessageDialog(null, "El método radixsort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenado) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada, por favor cargue otra");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cargue un archivo antes de ordenarlo");
                            ordenado = false;
                        }
                    }
                    break;
                case 5:
                    if (archivoCargado && !ordenado) {
                        vector = new Persona[lista.size()];
                        Quicksort sortQ = new Quicksort();
                        vector = (Persona[]) lista.toArray(vector);
                        inicio = System.currentTimeMillis();
                        sortQ.quickSort(vector);
                        fin = System.currentTimeMillis();
                        ordenado = true;
                        tiempo = fin - inicio;
                        JOptionPane.showMessageDialog(null, "El método quicksort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenado) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada, por favor cargue otra");
                        } else {
                            ordenado = false;
                            JOptionPane.showMessageDialog(null, "Cargue un archivo antes de ordenarlo");
                        }
                    }
                    break;
                case 6:
                    if (ordenado) {
                        BusquedaBinaria busqueda = new BusquedaBinaria();
                        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la cedula de la persona a buscar"));
                        if(busqueda.busquedaBinaria(vector, cedula) != null){
                            JOptionPane.showMessageDialog(null, "La persona encontrada es: " + busqueda.busquedaBinaria(vector, cedula));
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encuentra ninguna persona con esa cédula");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero tiene que ordenar el vector antes de poder buscar");
                    }
                    break;
                case 7:
                    if (archivoCargado) {
                        printArray(vector);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cargue un archivo primero");
                    }
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
