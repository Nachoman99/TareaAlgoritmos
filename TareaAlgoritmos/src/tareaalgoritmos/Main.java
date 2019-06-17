package tareaalgoritmos;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Esta es la clase para las pruebas
 * @author Jose Ignacio Zamora
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Persona> lista = new ArrayList<>();
        boolean salir = false;
        String ruta = "";
        Persona[] vectorShell = null;
        Persona[] vectorMerge = null;
        Persona[] vectorRadix = null;
        Persona[] vectorQuick = null;
        boolean ordenadoMerge = false;
        boolean ordenadoRadix = false;
        boolean ordenadoQuick = false;
        boolean ordenadoShell = false;
        boolean archivoCargado = false;
        long inicio;
        long fin;
        long tiempo;
        int opcion = 0;
        while (!salir) {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite una de las siguientes opciones: \n"
                        + "1) Cargar archivo.\n"
                        + "2) Ordenar con Shellsort.\n"
                        + "3) Ordenar con Mergesort.\n"
                        + "4) Ordenar con Radixsort.\n"
                        + "5) Ordenar con Quicksort.\n"
                        + "6) Buscar una persona. \n"
                        + "7) Imprimir.\n"
                        + "8) Salir."));
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite sólo números");
            }
            switch (opcion) {
                case 1:
                    ordenadoRadix = false;
                    ordenadoShell = false;
                    ordenadoMerge = false;
                    ordenadoQuick = false;
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
                    if (archivoCargado && !ordenadoShell) {
                        vectorShell = new Persona[lista.size()];
                        ShellSort sort = new ShellSort();
                        vectorShell = (Persona[]) lista.toArray(vectorShell);
                        inicio = System.currentTimeMillis();
                        sort.shellSort(vectorShell);
                        fin = System.currentTimeMillis();
                        tiempo = fin - inicio;
                        ordenadoShell = true;
                        JOptionPane.showMessageDialog(null, "El método shellsort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenadoShell) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada, por el método shellsort, por favor elija otra forma de ordenar o cargue otro archivo");
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor cargue un archivo antes de ordenar");
                            ordenadoShell = false;
                        }
                    }
                    break;
                case 3:
                    if (archivoCargado && !ordenadoMerge) {
                        vectorMerge = new Persona[lista.size()];
                        Mergesort sortM = new Mergesort();
                        vectorMerge = (Persona[]) lista.toArray(vectorMerge);
                        inicio = System.currentTimeMillis();
                        sortM.mergeSort(vectorMerge);
                        fin = System.currentTimeMillis();
                        ordenadoMerge = true;
                        tiempo = fin - inicio;
                        JOptionPane.showMessageDialog(null, "El método mergeSort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenadoMerge) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada, con el método mergesort, por favor use otro método o cargue otro archivo");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cargue un archivo antes de ordenarlo");
                            ordenadoMerge = false;
                        }
                    }
                    break;
                case 4:
                    if (archivoCargado && !ordenadoRadix) {
                        vectorRadix = new Persona[lista.size()];
                        RadixSort sortR = new RadixSort();
                        vectorRadix = (Persona[]) lista.toArray(vectorRadix);
                        inicio = System.currentTimeMillis();
                        sortR.radixsort(vectorRadix);
                        fin = System.currentTimeMillis();
                        ordenadoRadix = true;
                        tiempo = fin - inicio;
                        JOptionPane.showMessageDialog(null, "El método radixsort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenadoRadix) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada por el método radixsort, por favor utilice otro método o cargue otro archivo");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cargue un archivo antes de ordenarlo");
                            ordenadoRadix = false;
                        }
                    }
                    break;
                case 5:
                    if (archivoCargado && !ordenadoQuick) {
                        vectorQuick = new Persona[lista.size()];
                        Quicksort sortQ = new Quicksort();
                        vectorQuick = (Persona[]) lista.toArray(vectorQuick);
                        inicio = System.currentTimeMillis();
                        sortQ.quickSort(vectorQuick);
                        fin = System.currentTimeMillis();
                        ordenadoQuick = true;
                        tiempo = fin - inicio;
                        JOptionPane.showMessageDialog(null, "El método quicksort ha durado: " + tiempo + " milisegundos en ordenar la lista");
                    } else {
                        if (ordenadoQuick) {
                            JOptionPane.showMessageDialog(null, "La lista ya está ordenada por el metodo quicksort, por favor use otro método o cargue otro archivo");
                        } else {
                            ordenadoQuick = false;
                            JOptionPane.showMessageDialog(null, "Cargue un archivo antes de ordenarlo");
                        }
                    }
                    break;
                case 6:
                    if (ordenadoQuick || ordenadoMerge || ordenadoRadix || ordenadoShell) {
                        BusquedaBinaria busqueda = new BusquedaBinaria();
                        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la cedula de la persona a buscar"));
                        if (ordenadoQuick) {
                            if (busqueda.busquedaBinaria(vectorShell, cedula) != null) {
                                JOptionPane.showMessageDialog(null, "La persona encontrada es: " + busqueda.busquedaBinaria(vectorQuick, cedula));
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encuentra ninguna persona con esa cédula");
                            }
                        } else if (ordenadoRadix) {
                            if (busqueda.busquedaBinaria(vectorShell, cedula) != null) {
                                JOptionPane.showMessageDialog(null, "La persona encontrada es: " + busqueda.busquedaBinaria(vectorRadix, cedula));
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encuentra ninguna persona con esa cédula");
                            }
                        } else if (ordenadoShell) {
                            if (busqueda.busquedaBinaria(vectorShell, cedula) != null) {
                                JOptionPane.showMessageDialog(null, "La persona encontrada es: " + busqueda.busquedaBinaria(vectorShell, cedula));
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encuentra ninguna persona con esa cédula");
                            }
                        } else if (ordenadoMerge) {
                            if (busqueda.busquedaBinaria(vectorShell, cedula) != null) {
                                JOptionPane.showMessageDialog(null, "La persona encontrada es: " + busqueda.busquedaBinaria(vectorMerge, cedula));
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encuentra ninguna persona con esa cédula");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero tiene que ordenar el vector antes de poder buscar");
                    }
                    break;
                case 7:
                    if (archivoCargado) {
                        int imprimir = 0;
                        try {
                            imprimir = Integer.parseInt(JOptionPane.showInputDialog("Digite uno de las siguientes opciones\n"
                                    + "1) Imprimir con radixsort.\n"
                                    + "2) Imprimir con quicksort.\n"
                                    + "3) Imprimir con mergesort.\n"
                                    + "4) Imprimir con shellsort"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Digite sólo números");
                        }
                        switch (imprimir) {
                            case 1:
                                if (vectorRadix != null) {
                                    System.out.println(printArray(vectorRadix));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Primero ordene la lista con el método radixsort");
                                }
                                break;
                            case 2:
                                if (vectorQuick != null) {
                                    System.out.println(printArray(vectorQuick));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Primero ordene la lista con el método quicksort");
                                }
                                break;
                            case 3:
                                if (vectorMerge != null) {
                                    System.out.println(printArray(vectorMerge));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Primero ordene la lista con el método mergesort");
                                }
                                break;
                            case 4:
                                if (vectorShell != null) {
                                    System.out.println(printArray(vectorShell));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Primero ordene la lista con el método shellsort");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Elija una opción válida");
                                break;
                        }
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

    /**
     * Este método se encarga de leer los archivos txt
     *
     * @param ruta es la ruta donde se encuentra el archivo
     * @return un arrayList con todos los valores del archivo
     * @throws FileNotFoundException si no encuentra el archivo
     * @throws IOException si hay algún error en las entradas/salidas
     */
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

    /**
     * Este método imprime un vector
     *
     * @param arr vector a imprimir
     * @return los valores dentro del vector
     */
    public static String printArray(Persona[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + "\n";
        }
        return str;
    }
}
