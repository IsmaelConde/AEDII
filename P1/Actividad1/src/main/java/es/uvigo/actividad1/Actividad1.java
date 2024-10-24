/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uvigo.actividad1;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Ismael (Conde)²
 */
public class Actividad1 {

    public static void main(String[] args) {
        System.out.println(" ------------------ Ejercicio 1 ------------------ ");
        System.out.println("Factorial de 4: " + factorial(4));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 2 ------------------ ");
        System.out.println("Cuadrado de 5: " + cuadrado(5));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 3 ------------------ ");
        System.out.println("El dígito 9, suma: " + sumaDigitos(9));
        System.out.println("El dígito 1479, suma: " + sumaDigitos(1479));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 4 ------------------ ");
        System.out.println("El máximo común divisor de 2 y 4 es: " + maximoComunDivisor(3, 10));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 5 ------------------ ");
        System.out.println("La palabra invertida \"Universidad de Vigo\" es: " + invertirPalabra("Universidad de Vigo"));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 6 ------------------ ");
        System.out.println("La suma de los elementos del array {1,2,6,3} es: " + sumaElementosArray(new int[]{1,2,6,3}));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 7 ------------------ ");
        System.out.println("El array {1,2,3,4,5} en invertido es: " + Arrays.toString(invertirArray(new int[]{1,2,3,4,5})));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 8 ------------------ ");
        System.out.println("El menor del array {6,9,2,5,3} es: " + devolverMenor(new int[]{6,9,2,5,3}));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 9 ------------------ ");
        //System.out.println("El número 3.1 del array {} está en la posición : " + buscarNumero(new double[]{}, 3.1)); // Esta línea está comentada para que no salga el error, ya que está hecho a posta para comprobar
        System.out.println("El número 3.1 del array {1,2,8,3.1,3.5,6.3} está en la posición: " + buscarNumero(new double[]{1,2,8,3.1,3.5,6.3}, 3.1));
        System.out.println("El número 5 del array {1,3,8,2} está en la posición: " + buscarNumero(new double[]{1,3,8,2}, 5));
        System.out.println("---------------------------------------------------\n");
        
        System.out.println(" ------------------ Ejercicio 10 ------------------ ");
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        System.out.println("Pila(" + pila + ") == PilaCopia(" + copiarPila(pila) + ")");
        System.out.println("La pila original ha quedado así tras el proceso = " + pila);
        System.out.println("---------------------------------------------------\n");

    }
    
    /**
     * Implementa un método recursivo que calcule el factorial de un número entero positivo. Por ejemplo, 4! = 24. 
     * @param num El número de la recursividad del factorial
     * @return Devuelve el número con el factorial ya hecho
     */
    public static int factorial(int num){
        if(num == 1){
            return 1;
        }
        
        return factorial(num - 1) * num;
    }
    
    /**
     * Implementa un método recursivo que calcule el cuadrado de un número n, siendo n>= 0, sabiendo que n2 = (n-1)2 + 2n – 1. 
     * @param num El número que queremos calcular
     * @return Devuelve el número al cuadrado
     */
    public static int cuadrado(int num) throws IllegalArgumentException{
        if(num < 0){
            throw new IllegalArgumentException("No puedes dar valores inferiores a 0");
        }
        
        if(num == 0){
            return 0;
        }
        
        return cuadrado(num-1) + 2 * num - 1;
    }
    
    /**
     * Implementa un método recursivo que sume los dígitos que componen un número entero positivo que se pasa como parámetro. Es decir, dado el número 1369, debe devolver el entero 19. 
     * @param num El númeroq ue qeremos leer
     * @return Devuelve la suma de los dígitos de un número
     */
    public static int sumaDigitos(int num){
        if(num < 10){
            return num;
        }
        
        return (num%10) + sumaDigitos(num/10);
    }
    
    /**
     * Implementa un método recursivo que calcule el máximo común divisor de dos números enteros, aplicando el algoritmo de Euclides. Dicho algoritmo consiste en ir restando el número más pequeño del más grande hasta que queden dos números iguales, que serán el máximo común divisor de los dos números.
     * @param num1 Primer número a evaluar
     * @param num2 Segundo número a evaluar
     * @return Devuelve el maximo común divisor de ambos números
     */
    public static int maximoComunDivisor(int num1, int num2){
        if(num1 == 0){
            return num2;
        }else if(num2 == 0){
            return num1;
        }
        
        if(num1 > num2){
            return maximoComunDivisor(num1-num2, num2);
        }else if(num2 > num1){
            return maximoComunDivisor(num1, num2-num1);
        }
        
        return num1; // da igual, que sea el num1 o num2, en este punto, num1 == num2
    }
    
    /**
     * Implementa un método recursivo que invierta una palabra de forma recursiva. 
     * @param palabra La palabra a invertir
     * @return Devuelve la palabra invertida
     */
    public static String invertirPalabra(String palabra){
        int cantidad = palabra.length();
        
        return invertirPalabra(palabra, cantidad-1);
    }
    private static String invertirPalabra(String palabra, int pos){
        if(pos == 0){
            return palabra.charAt(0) + "";
        }
        
        return palabra.charAt(pos) + invertirPalabra(palabra, pos-1);
    }
    
    /**
     * Implementa un método recursivo que sume los elementos de un array de enteros. 
     * @param numsEnteros El array con los números enteros a sumar
     * @return Devuelve la cantida dsumada de todos los números enteros que están en el array
     */
    public static int sumaElementosArray(int[] numsEnteros){
        int cantidad = numsEnteros.length;
        
        return sumaElementosArray(numsEnteros, cantidad - 1);
    }
    private static int sumaElementosArray(int[] numsEnteros, int pos){
        if(pos == 0){
            return numsEnteros[pos];
        }
        
        return sumaElementosArray(numsEnteros,pos-1) + numsEnteros[pos];
    }
    
    /**
     * Implementa un método recursivo que invierta los números de un array de enteros.  
     * @param array El array a invertir
     * @return Devuelve el array invertido
     */
    public static int[] invertirArray(int[] array){
        int cantidad = array.length;
        
        invertirArray(array, 0, cantidad-1);
        
        return array;
    }
    private static void invertirArray(int[] array, int inicio, int fin){
        if(fin > inicio){
            int aux = array[inicio];
            array[inicio] = array[fin];
            array[fin] = aux;
            invertirArray(array, ++inicio, --fin);
        }
    }
    
    /**
     * Implementa un algoritmo recursivo que devuelva el menor elemento de un array de enteros.  
     * @param array El array en el que queremos buscar el número menor
     * @return Devuelve el número menor del array
     * @throws IllegalArgumentException En caso de que el Array esté vacío, satará una excepción
     */
    public static int devolverMenor(int[] array) throws IllegalArgumentException{
        int cantidad = array.length;
        if(cantidad <= 0){ // No tiene contenido
            throw new IllegalArgumentException("No se puede devolver el menor de un array vacío");
        }
        
        return devolverMenor(array, array[0], cantidad - 1);
    }
    private static int devolverMenor(int[] array, int menor, int pos){
        if(pos == 0){ // como el valor del 0 era el primer valor, ya no lo comparams, ya que ya se comparo durante toda la recursividad mientras no hubiese otro menor
            return menor;
        }
        
        if(array[pos] < menor){
            menor = array[pos];
        }
        
        return devolverMenor(array, menor, pos-1);
    }
    
    /**
     * Implementa la búsqueda binaria en un array de números reales ordenado de forma creciente, con un método recursivo. El método devuelve la posición del número a buscar en el array. Si no está, devuelve -1. 
     * @param array El array con los elementos
     * @param num El número a buscar en el array
     * @return Devuelve la posición del número en el array, si no existe, devuelve -1
     * @throws IllegalArgumentException En caso de que el array esté vacío, no vamos a perder el tiempo en buscar contenido
     */
    public static int buscarNumero(double[] array, double num) throws IllegalArgumentException{
        int cantidadArray = array.length;
        if(cantidadArray <= 0){
            throw new IllegalArgumentException("No puedes envíar un array vacío");
        }
        
        return buscarNumero(array, num, cantidadArray-1);
    }
    private static int buscarNumero(double[] array, double num, int pos){
        if(pos < 0){
            return -1;
        }
        
        if(array[pos] == num){
            return pos;
        }
        
        return buscarNumero(array, num, --pos);
    }
    
    /**
     *  Haciendo uso de la clase Stack<E> de Java, implementa un método recursivo que copie una pila genérica. Los elementos de la pila destino deben quedar en el mismo orden que en la pila original. 
     * @param <E> Párametro generico
     * @param pila La pila que queremos devolver
     * @return Devuelve la pila copiada
     */
    public static <E> Stack<E> copiarPila(Stack<E> pila){
        if(pila.isEmpty()){ // Está vacía
            return new Stack<>();
        }
        
        E contenido = pila.pop(); // lo sacamaos el último elemento de la lista
        
        Stack<E> pilaCopia = copiarPila(pila); // hacemos la recursividad con el resto de la pila
        
        pilaCopia.push(contenido); // Insertamos el contenido en la pila "copia"
        
        return pilaCopia;
    }
}
