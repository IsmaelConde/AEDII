/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles_TADs;

import Excepciones.HeapVacioExcepcion;

/**
 *
 * @author Ismael
 */
public class HeapBinario <E extends Comparable<E>> implements Heap<E> {
    private static final int TAMANHO = 10;
    private E[] array;
    private int numElem;
    
    /**
     * Produce: un objeto heap vacío
     */
    public HeapBinario(){
       array = (E[]) new Comparable[TAMANHO + 1];
    }

    /**
     * Produce: cierto si this está vacío. Falso en caso contrario. 
     * 
     * @return 
     */
    @Override
    public boolean esVacio() {
        return this.numElem == 0;
    }

    /**
     * Produce: si this está vacío lanza la excepción HeapVacioExcepcion, sino devuelve el objeto de más prioridad. 
     * Si varios objetos tienen igual prioridad devuelve el objeto que más tiempo lleva en el heap
     * 
     * @return
     * @throws HeapVacioExcepcion 
     */
    @Override
    public E recuperarMax() throws HeapVacioExcepcion {
        if(this.esVacio()) throw new HeapVacioExcepcion();
        return array[1]; // En la posición 1 siempre va estar el padre
    }

    /**
     * Produce: si this está vacío lanza la excepción HeapVacioExcepcion, sino devuelve el objeto de más prioridad 
     * y lo suprime.
     * @return
     * @throws HeapVacioExcepcion 
     */
    @Override
    public E suprimirMax() throws HeapVacioExcepcion {
        if(this.esVacio()) throw new HeapVacioExcepcion();
        E maximo = this.recuperarMax();
        
        this.intecambiar(1, this.numElem); // Establecemos el último nodo como el primero
        
        this.array[this.numElem] = null; // El último nodo se establece como null
        this.numElem -= 1; // Modificamos el número de elementos en el Array
        this.hundir(1);
        return maximo; // Devolvemos el valor máximo
    }
    
    /**
     * Función para intercambiar valores en el Array
     * @param i Posición del array para el intercambio
     * @param j Posición del array para el intercambio
     */
    private void intecambiar(int i, int j){
        E elementoTemporal = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = elementoTemporal;
    }
    
    /**
     * Este método llama al método hundir() (utilizado al suprimir) sobre cada nodo en sentido 
     * inverso al recorrido por niveles; cuando se realice la llamada con el nodo i se habrán 
     * procesado todos los descendientes del nodo i con una llamada a hundir()
     * 
     * @param pos 
     */
    private void hundir(int pos){
        if(this.esVacio()) return; // Si está vacío, ya no hay que ajustar nada
        if(2*pos > this.numElem) return; // No existe hijo, por lo que no hay que ajustar nada
        if((this.array[pos].compareTo(this.array[2*pos]) >= 0) && ((this.array[2*pos+1] == null) || (this.array[pos].compareTo(this.array[2*pos+1]) >= 0))) return; // El elemnto es mayor que sus hijos
        
        if((this.array[2*pos+1] == null) || (this.array[2*pos].compareTo(this.array[2*pos+1]) >= 0)){
            //intercambiar por hijo izquierdo y hundir
            this.intecambiar(pos, 2*pos);
            this.hundir(2*pos);
            return;
        }
        
        //intercambiar por hijo derecho y hundir
        this.intecambiar(pos, 2*pos+1);
        this.hundir(2*pos+1); 
    }

    /**
     * Produce: si e == null lanza la excepción NullPointerException; en otro caso, añade el objeto e al heap.
     * 
     * @param e
     * @throws NullPointerException 
     */
    @Override
    public void insertar(E e) throws NullPointerException {
        if(e == null) throw new NullPointerException("El elemento es null");
        if(this.numElem >= this.array.length - 1) this.duplicarArray(); // El array se queda pequeño, vamos ampliarlo
        
        int posicion = this.numElem + 1;
        this.array[posicion] = e;
        
        while((posicion < 1) && this.array[posicion].compareTo(this.array[posicion/2]) > 0){
            this.intecambiar(posicion, posicion/2);
            posicion = posicion/2;
        }
        
        ++this.numElem;
    }
    
    /**
     * Si vamos agregando datos al array, va llegar un momento que llegue a su máximo, por lo que
     * esta función aumenta ese espacio
     */
    private void duplicarArray(){
        E[] extensionArrayTemporal = (E[]) new Comparable[this.array.length + HeapBinario.TAMANHO];
        
        System.arraycopy(this.array, 0, extensionArrayTemporal, 0, this.array.length);
        
        this.array = extensionArrayTemporal;
    }
    
    /**
     * Función para automatizar el sistema de agrandar el array
     */
    private void comprobarTamanhoArray(){
        if(this.numElem >= this.array.length - 1) this.duplicarArray();
    }

    /**
     * Produce: elimina todos los elementos de this, quedando vacío.
     */
    @Override
    public void anular() {
        this.numElem = 0;
    }
    
    /**
     * Añade un objeto, pero no garantiza que se mantenga la propiedad 
     * de ordenación del heap o montículo binario. 
     * 
     * @param elem
     * @throws NullPointerException 
     */
    public void introducir(E elem) throws NullPointerException{
        if(elem == null) throw new NullPointerException("elem = null");
        this.comprobarTamanhoArray();
        
        this.array[++this.numElem] = elem;
    }
    
    /**
     * restablece el orden en el montículo. Debido a que es costoso, su 
     * uso está justificado si se realizan muchas operaciones introducir() entre dos accesos al 
     * elemento de mayor prioridad. 
     */
    public void arreglarHeap(){
        for(int i = this.numElem / 2; i > 0; i--){
            this.hundir(i);
        }
    }
    
}
