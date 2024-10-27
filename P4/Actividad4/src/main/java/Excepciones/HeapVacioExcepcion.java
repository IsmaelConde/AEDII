/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author Ismael
 */
public class HeapVacioExcepcion extends RuntimeException{
    
    public HeapVacioExcepcion(){
        super("El Heap está vacío");
    }
    
    public HeapVacioExcepcion(String mensaje){
        super(mensaje);
    }
}
