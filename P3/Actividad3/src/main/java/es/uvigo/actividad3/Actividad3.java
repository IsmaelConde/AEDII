/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uvigo.actividad3;

import Arboles_TADs.*;

/**
 *
 * @author Ismael (Conde)²
 */
public class Actividad3 {

    public static void main(String[] args) {
        ArbolBinario abc = construir("abc", "bac");
        
        System.out.println(" ------------------ Ejercicio 2.a ------------------ ");
        System.out.println("El árbol es: " + abc);
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 2.b ------------------ ");
        System.out.println("¿El camino \"ab\" existe en el arbol \"abc\"?: " + esCamino(abc, "ab"));
        System.out.println("¿El camino \"aj\" existe en el arbol \"abc\"?: " + esCamino(abc, "aj"));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 2.c ------------------ ");
        System.out.println("Padre del elemento \"b\": " + getPadre(abc, "b"));
        System.out.println("---------------------------------------------------\n");
    }
    
    /**
     * Escribe un método que dados los recorridos en preoden e inorden de un árbol binario, reconstruya el 
     * árbol. Suponemos que los recorridos son String y que no hay caracteres repetidos. 
     * 
     * @param preord
     * @param inord
     * @return 
     */
    public static ArbolBinario<Character> construir(String preord, String inord){
        if(preord.isEmpty()) return new EnlazadoArbolBinario<>();
        char raiz = preord.charAt(0);
        int ubi = inord.indexOf(raiz);
        
        String izqPre = preord.substring(1,ubi+1);
        String derPre = preord.substring(ubi + 1);
        
        String izqIn = inord.substring(0, ubi);
        String derIn = inord.substring(ubi + 1);
        
        return new EnlazadoArbolBinario<>(raiz,construir(izqPre, izqIn), construir(derPre, derIn));
    }
    
    /**
     * Escribe un método booleano que dados un árbol binario y un camino expresado en forma de String 
     * determine si existe dicho camino en el árbol, teniendo en cuenta que el camino debe comenzar 
     * necesariamente en la raíz
     * 
     * @param arbol
     * @param camino
     * @return 
     */
    public static boolean esCamino(ArbolBinario<Character> arbol, String camino){
        if(camino.isEmpty()) return true; // Devuelve true si el string es vacío
        if(!arbol.raiz().equals(camino.charAt(0))) return false;
        
        return esCamino(arbol.hijoIzq(), camino.substring(1)) || esCamino(arbol.hijoDer(), camino.substring(1));
    }
    
    /**
     * Escribe un método que dados un árbol binario y un elemento devuelva el padre de dicho elemento en 
     * el árbol, suponiendo que no hay elementos repetidos. Si el elemento no está en el árbol o es el elemento 
     * raíz, el método devuelve null.
     * 
     * @param <E>
     * @param a
     * @param elemento 
     */
    public static <E> E getPadre(ArbolBinario<E> a, E elemento){
        if(elemento == null) return null;
        if(a.esVacio()) return null;
        if(a.raiz().equals(elemento)) return null;
        if(a.hijoIzq().esVacio() || a.hijoDer().esVacio()) return null;
        if(a.hijoIzq().raiz().equals(elemento) ||a.hijoDer().raiz().equals(elemento)) return a.raiz();
        
        E padreIzq = getPadre(a.hijoIzq(), elemento);
        if(padreIzq == null) return getPadre(a.hijoDer(), elemento);
        
        return padreIzq;
    }
}
