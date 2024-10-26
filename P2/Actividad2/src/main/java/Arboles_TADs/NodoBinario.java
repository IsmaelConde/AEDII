/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles_TADs;

/**
 *
 * @author Ismael (Conde)²
 */
public class NodoBinario<E> {
    private E elemento; // referencia al elemento del nodo
    private NodoBinario<E> izq; // referencia al nodo izquierdo (hijo izquierdo)
    private NodoBinario<E> der; // referencia al nodo derecho (hijo derecho)
    
    public NodoBinario(E e, NodoBinario<E> hi, NodoBinario<E> hd){
        this.elemento = e;
        this.izq = hi;
        this.der = hd;
    }
    
    public E getElemento(){
        return this.elemento;
    }
    
    public NodoBinario<E> getIzq(){
        return this.izq;
    }
    
    public NodoBinario<E> getDer(){
        return this.der;
    }
    
    public void setElemento(E e){
        this.elemento = e;
    }
    
    public void setIzq(NodoBinario<E> hi){
        this.izq = hi;
    }
    
    public void setDer(NodoBinario<E> hd){
        this.der = hd;
    }
}
