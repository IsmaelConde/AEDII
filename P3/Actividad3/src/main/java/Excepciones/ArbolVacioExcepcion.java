/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author Ismael (Conde)²
 */
public class ArbolVacioExcepcion extends RuntimeException{
    public ArbolVacioExcepcion(){
        super("El árbol está vacío");
    }
    
    public ArbolVacioExcepcion(String mensaje){
        super(mensaje);
    }
}
