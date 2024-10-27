/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles_TADs;

import Excepciones.ArbolVacioExcepcion;

/**
 * Características: Un árbol binario es un árbol vacío o un nodo con dos hijos (izquierdo y derecho) que a su vez son árboles binarios. Los objetos son modificables. No admite elementos null
 * 
 * @author Ismael (Conde)²
 * @param <E> Generico
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E>{
    private NodoBinario<E> nodoRaiz;

    /**
     * Produce: Un árbol vacío
     */
    public EnlazadoArbolBinario() {
        this.nodoRaiz = null;
    }
    
    /**
     * Produce: Si elemRaiz, hi o hd son null, lanza la excepción NullPointerException. En caso controraio, construye un árbol de raíz elemRaiz, hijo izquierdo hi e hijo derecho hd
     * 
     * @param elemRaiz El nodo raiz del árbol a enlazar
     * @param hi Hijo izquierdo del nodo raiz
     * @param hd hijo derecho del nodo raíz
     * @throws NullPointerException 
     */
    public EnlazadoArbolBinario(E elemRaiz, ArbolBinario<E> hi, ArbolBinario<E> hd) throws NullPointerException{
        if(hi == null){
            throw new NullPointerException("Hijo izquierdo no puede ser null");
        }else if(hd == null){
            throw new NullPointerException("Hijo derecho no puede ser null");
        }else if(elemRaiz == null){
            throw new NullPointerException("El elemento Raíz no puede ser null");
        }
        
        this.nodoRaiz = new NodoBinario<>(null, null, null);
        this.setRaiz(elemRaiz);
        this.setHijoIzq(hi);
        this.setHijoDer(hd);
    }
    
    /**
     * Constructor que usaremos en los métodos hijoIzq(), hijoDer()
     * 
     * @param nodo 
     */
    private EnlazadoArbolBinario(NodoBinario<E> nodo){
        this.nodoRaiz = nodo;
    }
    
    /**
     * Produce: Cierto si this está vacío. Falso en caso contrario.  
     * 
     * @return
     */
    @Override
    public boolean esVacio() {
        return this.nodoRaiz == null;
    }

    /**
     * Produce: Si this está vacío lanza la excepción ArbolVacioExcepcion, sino devuelve el objeto almacenado en la raíz 
     * 
     * @return
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if(this.esVacio())throw new ArbolVacioExcepcion();
        
        return this.nodoRaiz.getElemento();
    }

    /**
     * Produce: Si this está vacío lanza la excepción ArbolVacioExcepcion, sino devuelve el subárbol izquierdo
     * 
     * @return
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if(this.esVacio())throw new ArbolVacioExcepcion();
        
        return new EnlazadoArbolBinario<>(this.nodoRaiz.getIzq()); // Para poder pasar el "NodoBinario" al "ArbolBinario" (lo que queremos devolver) tenemos el contructor de la clase "EnlazadoArbolBinario", ya que este extiende de "ArbolBinario" (lo que queremos)
    }

    /**
     * Produce: Si this está vacío lanza la excepción ArbolVacioExcepcion, sino devuelve el subárbol derecho
     * 
     * @return
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if(this.esVacio())throw new ArbolVacioExcepcion();
        
        return new EnlazadoArbolBinario<>(this.nodoRaiz.getDer()); // Para poder pasar el "NodoBinario" al "ArbolBinario" (lo que queremos devolver) tenemos el contructor de la clase "EnlazadoArbolBinario", ya que este extiende de "ArbolBinario" (lo que queremos)
    }

    /**
     * Produce: Cierto si elemento está en this, falso, en caso contrario
     * 
     * @param elemento
     * @return 
     */
    @Override
    public boolean esta(E elemento) {
        if(this.esVacio()) return false;
        if(this.raiz().equals(elemento)) return true;
        return this.hijoIzq().esta(elemento) || this.hijoDer().esta(elemento);
    }

    /**
     * Produce: si this está vacío lanza la excepción ArbolVacioExcepcion, si elemRaiz es null lanza NullPointerException; sino asigna el objeto elemRaiz a la raíz del árbol this
     * 
     * @param elemRaiz
     * @throws ArbolVacioExcepcion
     * @throws NullPointerException 
     */
    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion, NullPointerException {
        if(this.esVacio()) throw new ArbolVacioExcepcion();
        if(elemRaiz == null) throw new NullPointerException("elemRaiz es null");
        
        this.nodoRaiz.setElemento(elemRaiz);
    }

    /**
     * Si hi es null, lanza la excepción NullPointerException
     * En caso contrario, si this está vacío lanza la excepción ArbolVacioExcepcion,
     * sino asigna el árbol hi como subárbol izquierdo de this
     * 
     * @param hi
     * @throws ArbolVacioExcepcion
     * @throws NullPointerException 
     */
    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if(hi == null) throw new NullPointerException("hi es null");
        if(this.esVacio()) throw new ArbolVacioExcepcion();
        
        this.nodoRaiz.setIzq(((EnlazadoArbolBinario) hi).nodoRaiz);
    }

    /**
     * Si hd es null, lanza la excepción NullPointerException.
     * En caso contrario, si this está vacío lanza la excepción ArbolVacioExcepcion,
     * sino asigna el árbol hd como subárbol derecho de this
     * 
     * @param hd
     * @throws ArbolVacioExcepcion
     * @throws NullPointerException 
     */
    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if(hd == null) throw new NullPointerException("hd es null");
        if(this.esVacio()) throw new ArbolVacioExcepcion();
        
        this.nodoRaiz.setDer(((EnlazadoArbolBinario) hd).nodoRaiz);
    }

    /**
     * Produce: El árbol binario vacío
     */
    @Override
    public void suprimir() {
        this.nodoRaiz = null;
    }
    
    // Extra para el main
    @Override
    public String toString(){
        return "\n\t|" + this.raiz() + "|\n|" + this.hijoIzq().raiz() + "|\t\t|" + this.hijoDer().raiz() + "|";
    }
    public String toString(ArbolBinario<E> arbol){
        if(arbol.esVacio()) return "";
        return "\n\t" + this.raiz() + "\n" + toString(this.hijoIzq()) + "\t" + toString(this.hijoDer());
    }
}
