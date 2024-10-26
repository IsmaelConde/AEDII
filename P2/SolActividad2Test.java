
package gal.uvigo.esei.aed2.solactividad2;

import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;

import org.junit.Test;
import static org.junit.Assert.*;


public class SolActividad2Test {   
    private static final ArbolBinario<Integer> vacio = new EnlazadoArbolBinario<>();
    private static final ArbolBinario<Integer> hoja1 = new EnlazadoArbolBinario<>(3, vacio, vacio);
    private static final ArbolBinario<Integer> hoja11 = new EnlazadoArbolBinario<>(3, vacio, vacio);
    private static final ArbolBinario<Integer> hoja2 = new EnlazadoArbolBinario<>(5, vacio, vacio);
    private static final ArbolBinario<Integer> hoja3 = new EnlazadoArbolBinario<>(7, vacio, vacio);
    private static final ArbolBinario<Integer> nodo1 = new EnlazadoArbolBinario<>(11, hoja1, hoja2); 
    private static final ArbolBinario<Integer> nodo2 = new EnlazadoArbolBinario<>(3, hoja1, hoja2);
    private static final ArbolBinario<Integer> raiz = new EnlazadoArbolBinario<>(7, nodo1, hoja3);
    private static final ArbolBinario<Integer> selec = new EnlazadoArbolBinario<>(3, nodo2, hoja3);
    private static final ArbolBinario<Integer> degen = new EnlazadoArbolBinario<>(1, new EnlazadoArbolBinario<>(13, vacio, hoja3), vacio);
    private static final ArbolBinario<Integer> nodoSinHojas = new EnlazadoArbolBinario<>(11, vacio, vacio);
    private static final ArbolBinario<Integer> raizSinHojas = new EnlazadoArbolBinario<>(7, nodoSinHojas, vacio);
    private static final ArbolBinario<Integer> raizHasta1 = new EnlazadoArbolBinario<>(7, nodoSinHojas, hoja3);

    private static final ArbolBinario<Character> vacioChar = new EnlazadoArbolBinario<>();
    private static final ArbolBinario<Character> hoja2Char = new EnlazadoArbolBinario<>('5', vacioChar, vacioChar);
    private static final ArbolBinario<Character> hoja1Char = new EnlazadoArbolBinario<>('3', vacioChar, vacioChar);
    private static final ArbolBinario<Character> nodo1Char = new EnlazadoArbolBinario<>('6', hoja1Char, hoja2Char); 

    private static final ArbolBinario<Character> hoja4Char = new EnlazadoArbolBinario<>('1', vacioChar, vacioChar);
    private static final ArbolBinario<Character> hoja5Char = new EnlazadoArbolBinario<>('8', vacioChar, vacioChar);
    private static final ArbolBinario<Character> nodo2Char = new EnlazadoArbolBinario<>('2', hoja4Char, hoja5Char);
    private static final ArbolBinario<Character> arbolCamino = new EnlazadoArbolBinario<>('7', nodo1Char, nodo2Char);
	
    
    /**
     * Ejercicio 1
     * Test of completo method, of class SolActividad2.
     */
    @Test
    public void testVacioCompleto() {
        System.out.println("Test 'completo' con arbol vacío");
        boolean expResult = true;
        boolean result = SolActividad2.completo(vacio);
        assertEquals(expResult, result);
    }
    @Test
    public void testHojaCompleto() {
        System.out.println("Test 'completo' con arbol 'hoja3'");
        boolean expResult = true;
        boolean result = SolActividad2.completo(hoja3);
        assertEquals(expResult, result);
    }
    @Test
    public void testNoCompleto() {
        System.out.println("Test 'completo' con arbol 'degen'");
        boolean expResult = false;
        boolean result = SolActividad2.completo(degen);
        assertEquals(expResult, result);
    }
    @Test
    public void testCompleto() {
        System.out.println("Test 'completo' con arbol 'raiz'");
        boolean expResult = true;
        boolean result = SolActividad2.completo(raiz);
        assertEquals(expResult, result);
    }
    
    
    
    /**
     * Ejercicio 2
     * Test of identicos method, of class SolActividad2.
     */
    @Test
    public void testVacioIdenticos() {
        System.out.println("Test 'identicos' con árboles vacios");
        boolean expResult = true;
        boolean result = SolActividad2.identicos(vacio, new EnlazadoArbolBinario<>() );
        assertEquals(expResult, result);
    }
    @Test
    public void testHojaIdenticos() {
        System.out.println("Test 'identicos' con árboles 'hoja1' y 'hoja11'");
        boolean expResult = true;
        boolean result = SolActividad2.identicos(hoja1, hoja11);
        assertEquals(expResult, result);
    }
    @Test
    public void testNoIdenticos() {
        System.out.println("Test 'identicos' con árboles 'raiz' y 'selec'");
        boolean expResult = false;
        boolean result = SolActividad2.identicos(raiz, selec);
        assertEquals(expResult, result);
    }
    @Test
    public void testIdenticos() {
        System.out.println("Test 'identicos' con el mismo árbol");
        boolean expResult = true;
        boolean result = SolActividad2.identicos(raiz, raiz);
        assertEquals(expResult, result);
    }

    /**
     * Test of copia method, of class SolActividad2., tranparencias
     */
    @Test
    public void testVacioCopia() {
        System.out.println("Test 'copia' con árbol vacío");
        ArbolBinario expResult = vacio;
        ArbolBinario result = SolActividad2.copia(vacio);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }
    @Test
    public void testCopia() {
        System.out.println("Test 'copia' con árbol 'raiz'");
        ArbolBinario expResult = raiz;
        ArbolBinario result = SolActividad2.copia(raiz);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }

    /**
     * Ejercicio 3
     * Test of contarNivel method, of class SolActividad2.
     */
    @Test
    public void testVacioContarNivel() {
        System.out.println("Test 'contarNivel' con árbol vacío");
        int expResult = 0;
        int result = SolActividad2.contarNivel(vacio, 0);
        assertEquals(expResult, result);
    }
    @Test
    public void testNoContarNivel() {
        System.out.println("Test 'contarNivel' con árbol 'hoja1'");
        int expResult = 0;
        int result = SolActividad2.contarNivel(hoja1, 2);
        assertEquals(expResult, result);
    }
    @Test
    public void testContarNivel() {
        System.out.println("Test 'contarNivel' con árbol 'raiz'");
        int expResult = 2;
        int result = SolActividad2.contarNivel(raiz, 2);
        assertEquals(expResult, result);
    }

       
    /**
      * Ejercicio 4   
     * Test of eliminarHojas method, of class SolActividad2.
     */
    @Test
    public void testVacioEliminarHojas() {
        System.out.println("Test 'eliminarHojas' con árbol 'hoja1'");
        ArbolBinario expResult = vacio;
        ArbolBinario result = SolActividad2.eliminarHojas(hoja1);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }
    @Test
    public void testEliminarHojas() {
        System.out.println("Test 'eliminarHojas' con árbol 'raiz'");
        ArbolBinario expResult = raizSinHojas;
        ArbolBinario result = SolActividad2.eliminarHojas(raiz);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }

    /**
     * Ejercicio 5
     * Test of altura method, of class SolActividad2.
     */
    @Test
    public void testAlturaVacio() {
        System.out.println("Test 'altura' con árbol vacío");
        int expResult = -1;
        int result = SolActividad2.altura(vacio);
        assertEquals(expResult, result);
    }
    @Test
    public void testAlturaHoja() {
        System.out.println("Test 'altura' con árbol 'hoja1'");
        int expResult = 0;
        int result = SolActividad2.altura(hoja1);
        assertEquals(expResult, result);
    }
    @Test
    public void testAltura() {
        System.out.println("Test 'altura' con árbol 'raiz'");
        int expResult = 2;
        int result = SolActividad2.altura(raiz);
        assertEquals(expResult, result);
    }
   
    
    /**
     * Ejercicio 6
     * Test of arbolSeleccion method, of class SolActividad2.
     */
    @Test
    public void testVacioEsArbolSeleccion() {
        System.out.println("Test 'esArbolSelección' con árbol vacío");
        boolean expResult = true;
        boolean result = SolActividad2.esArbolSeleccion(vacio);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testHojaEsArbolSeleccion() {
        System.out.println("Test 'esArbolSelección' con árbol 'hoja1'");
        boolean expResult = true;
        boolean result = SolActividad2.esArbolSeleccion(hoja1);
        assertEquals(expResult, result);
    }
    @Test
    public void testNoEsArbolSeleccion() {
        System.out.println("Test 'esArbolSelección' con árbol 'raiz'");
        boolean expResult = false;
        boolean result = SolActividad2.esArbolSeleccion(raiz);
        assertEquals(expResult, result);   
    }
    @Test
    public void testEsArbolSeleccion() {
        System.out.println("Test 'esArbolSelección' con árbol 'selec'");
        boolean expResult = true;
        boolean result = SolActividad2.esArbolSeleccion(selec);
        assertEquals(expResult, result);
    }

   
   /**
     * Ejercicio 7
     * Test of existeSuma method, of class SolActividad2.
     */
    @Test
    public void testExisteSuma() {
        System.out.println("Test 'existeSuma' con árbol raizSinHojas");
        ArbolBinario<Integer> arbol = raizSinHojas;
        Integer suma = 11;
        boolean expResult = true;
        boolean result = SolActividad2.existeSuma(arbol, suma);
        assertEquals(expResult, result);
    }
    @Test
    public void testExisteSumaFalse() {
        System.out.println("Test 'existeSuma' con árbol raizSinHojas");
        ArbolBinario<Integer> arbol = raizSinHojas;
        Integer suma = 18;
        boolean expResult = false;
        boolean result = SolActividad2.existeSuma(arbol, suma);
        assertEquals(expResult, result);
    } 
    @Test
    public void testExisteSuma2() {
        System.out.println("Test 'existeSuma' con árbol selec");
        ArbolBinario<Integer> arbol = selec;
        Integer suma = 18;
        boolean expResult = true;
        boolean result = SolActividad2.existeSuma(arbol, suma);
        assertEquals(expResult, result);
    } 
    
    
    /**
      * Ejercicio 8
     * Test of copiaHastaNivel method, of class SolActividad2.
     */
    @Test
    public void testVacioCopiaHastaNivel() {
        System.out.println("Test 'copiaHastaNivel' con árbol vacío y nivel 0");
        ArbolBinario expResult = vacio;
        ArbolBinario result = SolActividad2.copiaHastaNivel(vacio, 0);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }
    @Test
    public void testCopiaHastaNivel1() {
        System.out.println("Test 'copiaHastaNivel' con árbol 'raiz' y nivel 1");
        ArbolBinario expResult = raizHasta1;
        ArbolBinario result = SolActividad2.copiaHastaNivel(raiz, 1);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }
    @Test
    public void testCopiaHastaNivel2() {
        System.out.println("Test 'copiaHastaNivel' con árbol 'raiz' y nivel 2");
        ArbolBinario expResult = raiz;
        ArbolBinario result = SolActividad2.copiaHastaNivel(raiz, 2);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }
    @Test
    public void testSobreCopiaHastaNivel() {
        System.out.println("Test 'copiaHastaNivel' con árbol 'raiz' y nivel 4");
        ArbolBinario expResult = raiz;
        ArbolBinario result = SolActividad2.copiaHastaNivel(raiz, 4);
        boolean eq = SolActividad2.identicos(expResult, result);
        assertTrue(eq);
    }

    /**
     * Ejercicio 9
     * Test of padre method, of class SolActividad2.
     */
    @Test
    public void testDistanciaVacioFalse() {
        System.out.println("Test 'distanciaK' con árbol vacío, elemento 2 y distancia 0");
        assertFalse(SolActividad2.esDistanciaK(vacio, 2, 0));
    }
    @Test
    public void testDistanciaFalse() {
        System.out.println("Test 'distanciaK' con árbol 'raiz', elemento 5 y distancia 1");
        assertFalse(SolActividad2.esDistanciaK(raiz, 5, 1));
    }
    @Test
    public void testDistanciaTrue() {
        System.out.println("Test 'distanciaK' con árbol 'raiz', elemento 5 y distancia 2");
        assertTrue(SolActividad2.esDistanciaK(raiz, 5, 2));
    }

   

    

    
    
}