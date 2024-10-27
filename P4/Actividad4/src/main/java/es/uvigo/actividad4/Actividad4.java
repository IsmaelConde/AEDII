/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uvigo.actividad4;

import Arboles_TADs.HeapBinario;

/**
 *
 * @author Ismael (Conde)²
 */
public class Actividad4 {

    public static void main(String[] args) {
        System.out.println("Clases Heap y HeapBinario creadas 😎");
        int[] elementos = {23,45,12,34,67,43,76,88,69,28,61};
        heapSort(elementos);
    }
    
    public static int[] heapSort(int[] elementos){
        int[] array = new int[elementos.length];
        HeapBinario<Integer> heap = new HeapBinario<>();
        for(int e: elementos){
            heap.introducir(e);
        }
        heap.arreglarHeap();
        int i = 0;
        while(!heap.esVacio()){
            array[i++] = heap.suprimirMax();
        }
        return array;
    }
}
