/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles_TADs;

import Excepciones.HeapVacioExcepcion;

/**
 *
 * @author Ismael (Conde)²
 * @param <E> Generico
 */
public interface Heap <E> {
    public boolean esVacio();
    public E recuperarMax() throws HeapVacioExcepcion;
    public E suprimirMax() throws HeapVacioExcepcion;
    public void insertar(E e) throws NullPointerException;
    public void anular();
}
