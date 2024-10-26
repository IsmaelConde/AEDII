/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uvigo.actividad2;

import Arboles_TADs.*;

/**
 *
 * @author Ismael (Conde)²
 */
public class Actividad2 {

    public static void main(String[] args) {
        ArbolBinario<Integer> hi = new EnlazadoArbolBinario<>();
        ArbolBinario<Integer> hd = new EnlazadoArbolBinario<>();
        
        ArbolBinario<Integer> raiz = new EnlazadoArbolBinario<>(1,hi,hd);
        
        System.out.println(" ------------------ Ejercicio 1 ------------------ ");
        System.out.println("¿El árbol, está completo? : " + completo(raiz));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 2 ------------------ ");
        System.out.println("¿Los arboles hi y hd, son identicos? : " + identicos(hi, hd));
        //System.out.println("¿Los arboles raiz y hd, son identicos? : " + identicos(raiz, hd));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 3 ------------------ ");
        System.out.println("Nodos en el nivel 0 : " + contarNivel(raiz, 0));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 4 ------------------ ");
        System.out.println("El árbol base es : " + raiz.toString());
        System.out.println("Su copia sin hojas es: " + copiarArbolSinHojas(raiz).toString());
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 5 ------------------ ");
        System.out.println("La altura del arbol raiz es : " + calcularAltura(raiz));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 6 ------------------ ");
        System.out.println("¿Es árbol selección el árbol \"raiz\"? : " + esArbolSeleccion(raiz));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 7 ------------------ ");
        System.out.println("¿Existe la suma de 3 en el árbol \"raiz\"? : " + existeSuma(raiz, 3));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 8 ------------------ ");
        System.out.println("La copia del árbol \"raiz\"(" + raiz.toString() + ") es : " + copiaHastaNivel(raiz, 3));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 9 ------------------ ");
        System.out.println("¿Está el elemento \"2\" a \"1\" distancia de la raíz en el árbol \"raiz\"? : " + esDistanciaK(raiz, 2, 1));
        System.out.println("---------------------------------------------------\n");
    }
    
    /**
     *  Escribe un método que dado un árbol binario devuelva verdadero si el árbol es completo y falso en 
     *  otro caso. Un árbol binario es completo si todos sus nodos tienen dos descendientes, excepto las hojas. 
     * 
     * @param arbol ArbolBinario a comprobar
     * @return devuelve true si es completo y false en caso de que no sea así
     */
    public static boolean completo(ArbolBinario arbol){
        if(arbol.esVacio()) return true;
        if((arbol.hijoIzq().esVacio() || arbol.hijoDer().esVacio()) && (!arbol.hijoIzq().esVacio() || !arbol.hijoDer().esVacio())) return false;
        
        return completo(arbol.hijoIzq()) && completo(arbol.hijoDer());
    }
    
    /**
     * Escribe un método que dados dos árboles binarios A y B, determine si son idénticos o no. 
     * 
     * @param arbol1 Primer ArbolBinario a comparar
     * @param arbol2 Segundo ArbolBinario a comparar
     * @return Devuelve true si son identicos y false en caso de que no sean identicos
     */
    public static boolean identicos(ArbolBinario arbol1, ArbolBinario arbol2){
        if(arbol1.esVacio() && arbol2.esVacio()) return true;
        if(!arbol1.raiz().equals(arbol2.raiz())) return false;
        
        return identicos(arbol1.hijoIzq(), arbol2.hijoIzq()) && identicos(arbol1.hijoDer(), arbol2.hijoDer());
    }
    
    /**
     * Escribe un método que cuente el número de nodos que están en el nivel n de un árbol binario.
     * 
     * @param arbol El árbol a medir
     * @param nivel El nivel que queremos comprobar
     * @return Devuelve el número de nodos que están en el nivel del ArbolBinario
     * @throws IllegalArgumentException 
     */
    public static int contarNivel(ArbolBinario arbol, int nivel) throws IllegalArgumentException {
        if(nivel < 0){
            throw new IllegalArgumentException("No puedes pasar un nivel inferior a 0");
        }
        
        if(arbol.esVacio()) return 0;
        if(nivel == 0) return 1;
        
        return contarNivel(arbol.hijoIzq(), nivel - 1) + contarNivel(arbol.hijoDer(), nivel - 1); // Hago "nivel - 1" ya que al bajar a los hijos, ahora los hijos son nivel 0
    }
    
    /**
     * Escribe un método que dado un árbol binario A, cree un árbol binario B igual que A, pero sin las hojas. 
     * 
     * @param <E> Generico
     * @param arbol El árbol a copiar
     * @return Devuelve el arbol pasado sin hojas
     */
    public static <E> ArbolBinario<E> copiarArbolSinHojas(ArbolBinario<E> arbol){
        if(arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()) return new EnlazadoArbolBinario<>();
        
        return new EnlazadoArbolBinario(arbol.raiz(), copiarArbolSinHojas(arbol.hijoIzq()), copiarArbolSinHojas(arbol.hijoDer()));
    }
    
    /**
     * Escribe un método que calcule la altura de un árbol binario. 
     * 
     * @param arbol El árbol a medir
     * @return Devuelve la máxima altura del árbol
     */
    public static int calcularAltura(ArbolBinario arbol){
        if(arbol.esVacio()) return -1; // Para que al llegar a una hoja, contrareste el 1 que está en el return de este algoritmo
        
        return 1 + Math.max(calcularAltura(arbol.hijoIzq()),calcularAltura(arbol.hijoDer())); // Math.max devuelve el valor más alto de los 2
    }
    
    /**
     * Un árbol de selección es un árbol binario donde cada nodo representa al menor de sus dos hijos, 
     * excepto las hojas. Construir un método que, dado un árbol binario, indique si es o no un árbol de 
     * selección.
     * 
     * @param <E> Generico
     * @param arbol El arbol a hacer las mediciones
     * @return Devuelve si es o no un árbol de selección
     */
    public static <E extends Comparable<E>> boolean esArbolSeleccion(ArbolBinario<E> arbol){
        if(arbol.esVacio()) return true;
        if(arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()) return true;
        
        E minimo;
        
        if(arbol.hijoIzq().esVacio()){
            minimo = arbol.hijoDer().raiz();
        }else if(arbol.hijoDer().esVacio()){
            minimo = arbol.hijoIzq().raiz();
        }else if(arbol.hijoIzq().raiz().compareTo(arbol.hijoDer().raiz()) < 0){
            minimo = arbol.hijoIzq().raiz();
        }else{
            minimo = arbol.hijoDer().raiz();
        }
        
        if(!arbol.raiz().equals(minimo)) return false;
        
        return esArbolSeleccion(arbol.hijoIzq()) && esArbolSeleccion(arbol.hijoDer());
    }
    
    /**
     * Dado un árbol binario de enteros escribe el método existeSuma, que devuelve cierto si existe al 
     * menos un nodo del árbol tal que la suma de todos sus nodos descendientes es igual al parámetro suma. 
     * Haciendo uso del TAD Árbol Binario disponible en el anexo, escribe dicho método:  
     * 
     * @param <E>
     * @param arbol
     * @param suma
     * @return 
     */
    public static <E> boolean existeSuma(ArbolBinario<Integer> arbol, Integer suma){
        if(arbol.esVacio()) return false;
        
        int sumatorioHijos = sumaHijos(arbol);
        
        if(suma == sumatorioHijos) return true;
        
        return existeSuma(arbol.hijoIzq(), suma) || existeSuma(arbol.hijoDer(), suma);
    }
    private static int sumaHijos(ArbolBinario<Integer> arbol){
        if(arbol.esVacio()){
            return 0;
        }
        
        return arbol.raiz() + sumaHijos(arbol.hijoIzq()) + sumaHijos(arbol.hijoDer());
    }
    
    /**
     * Escribe un método que dado un árbol binario y un nivel n del árbol, realice una copia del árbol hasta 
     * dicho nivel. 
     * @param <E>
     * @param a
     * @param nivel
     * @return 
     */
    public static <E> ArbolBinario<E> copiaHastaNivel(ArbolBinario<E> a, int nivel){
        if(nivel < 0 || a.esVacio()) return new EnlazadoArbolBinario<>(); // Si se pasa un nivel inferior se devuelve un árbol vacío
        if(nivel > calcularAltura(a)) return a; // Si el nivel es mayor que el que tiene el árbol, se devuelve el árbol entero
        
        return new EnlazadoArbolBinario<>(a.raiz(), copiaHastaNivel(a.hijoIzq(), nivel - 1), copiaHastaNivel(a.hijoDer(), nivel - 1));
    }
    
    /**
     * Un elemento de un árbol se dirá de nivel k si aparece en el árbol a distancia k de la raíz. Escribe un 
     * método que determine si un elemento está a distancia k. 
     * @param <E>
     * @param a
     * @param elem
     * @param k
     * @return 
     */
    public static <E> boolean esDistanciaK(ArbolBinario<E> a, E elem, int k){
        if(a.esVacio()) return false;
        if(elem.equals(a.raiz()) && k == 0) return true;
        if(!elem.equals(a.raiz())) return false;
        
        return esDistanciaK(a.hijoIzq(), elem, --k) || esDistanciaK(a.hijoDer(), elem, --k);
    }
}
