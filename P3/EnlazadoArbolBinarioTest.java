
package gal.uvigo.esei.aed2.solactividad3;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 */
public class EnlazadoArbolBinarioTest {

    EnlazadoArbolBinario<Integer> vacio;
    EnlazadoArbolBinario<Integer> hoja1;
    EnlazadoArbolBinario<Integer> hoja2;
    EnlazadoArbolBinario<Integer> hoja3;
    EnlazadoArbolBinario<Integer> nodo1;
    EnlazadoArbolBinario<Integer> raiz;

    public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (!a.esVacio() && !b.esVacio()) {
            return a.raiz().equals(b.raiz())
                    && identicos(a.hijoIzq(), b.hijoIzq())
                    && identicos(a.hijoDer(), b.hijoDer());
        } else {
            return a.esVacio() && b.esVacio();
        }
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        vacio = new EnlazadoArbolBinario<>();
        hoja1 = new EnlazadoArbolBinario<>(3, vacio, vacio);
        hoja2 = new EnlazadoArbolBinario<>(5, vacio, vacio);
        hoja3 = new EnlazadoArbolBinario<>(7, vacio, vacio);
        nodo1 = new EnlazadoArbolBinario<>(6, hoja1, hoja2);
        raiz = new EnlazadoArbolBinario<>(4, nodo1, hoja3);
    }

    /**
     * Test of esVacio method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEsVacio() {
        System.out.println("Test 'esVacio' con árbol vacío");
        ArbolBinario<Integer> instance = new EnlazadoArbolBinario();
        boolean expResult = true;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }

    @Test
    public void testEsVacioFalse() {
        System.out.println("Test 'esVacio' con árbol 'hoja1'");
        ArbolBinario<Integer> instance = hoja1;
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of raiz method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testRaiz() {
        System.out.println("Test 'raiz' con árbol 'hoja1'");
        ArbolBinario<Integer> instance = hoja1;
        Integer expResult = 3;
        Integer result = instance.raiz();
        assertEquals(expResult, result);
    }

    @Test(expected = ArbolVacioExcepcion.class)
    public void testRaizVacio() {
        System.out.println("Test 'raiz' con árbol vacío");
        ArbolBinario<Integer> instance = vacio;
        Integer result = instance.raiz();
    }

    /**
     * Test of esta method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testEsta() {
        System.out.println("Test 'esta' con árbol 'raiz' y elemento 4");
        Integer elemento = 4;
        ArbolBinario<Integer> instance = raiz;
        boolean expResult = true;
        boolean result = instance.esta(elemento);
        assertEquals(expResult, result);
    }

    @Test
    public void testEstaFalse() {
        System.out.println("Test 'esta' con árbol 'raiz' y elemento 2");
        Integer elemento = 2;
        ArbolBinario<Integer> instance = raiz;
        boolean expResult = false;
        boolean result = instance.esta(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Test of hijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test(expected = ArbolVacioExcepcion.class)
    public void testHijoIzq() {
        System.out.println("Test 'hijoIzq' con árbol vacio");
        ArbolBinario<Integer> instance = vacio;
        ArbolBinario result = instance.hijoIzq();
    }

    @Test
    public void testHijoIzqTrue() {
        System.out.println("Test 'hijoIzq' con árbol 'raiz'");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = nodo1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertTrue(identicos(expResult, result));
    }

    @Test
    public void testHijoIzqFalse() {
        System.out.println("Test 'hijoIzq' con árbol 'raiz'");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja1;
        ArbolBinario<Integer> result = instance.hijoIzq();
        assertFalse(identicos(expResult, result));
    }

    /**
     * Test of hijoDer method, of class EnlazadoArbolBinario.
     */
    @Test(expected = ArbolVacioExcepcion.class)
    public void testHijoDer() {
        System.out.println("Test 'hijoDer' con árbol vacio");
        ArbolBinario<Integer> instance = vacio;
        ArbolBinario<Integer> result = instance.hijoDer();
    }

    @Test
    public void testHijoDerTrue() {
        System.out.println("Test 'hijoDer' con árbol 'raiz'");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja3;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertTrue(identicos(expResult, result));
    }

    @Test
    public void testHijoDerFalse() {
        System.out.println("Test 'hijoDer' con árbol 'raiz'");
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = hoja1;
        ArbolBinario<Integer> result = instance.hijoDer();
        assertFalse(identicos(expResult, result));
    }

    /**
     * Test of setRaiz method, of class EnlazadoArbolBinario.
     */
    @Test(expected = ArbolVacioExcepcion.class)
    public void testSetRaiz() {
        System.out.println("Test 'setRaiz' en árbol vacío");
        Integer elemRaiz = 2;
        ArbolBinario<Integer> instance = vacio;
        instance.setRaiz(elemRaiz);
    }

    @Test(expected = NullPointerException.class)
    public void testSetRaizNull() {
        System.out.println("Test 'setRaiz' con parámetro null");
        Integer elemRaiz = null;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
    }
    
    @Test
    public void testSetRaizTrue() {
        System.out.println("Test 'setRaiz' en árbol 'hoja1'");
        Integer elemRaiz = 5;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertTrue(identicos(instance, hoja2));
    }

    @Test
    public void testSetRaizFalse() {
        System.out.println("Test 'setRaiz' en árbol 'hoja1'");
        Integer elemRaiz = 4;
        ArbolBinario<Integer> instance = hoja1;
        instance.setRaiz(elemRaiz);
        assertFalse(identicos(instance, hoja2));
    }

    /**
     * Test of setHijoIzq method, of class EnlazadoArbolBinario.
     */
    @Test(expected = ArbolVacioExcepcion.class)
    public void testSetHijoIzq() {
        System.out.println("Test 'setHijoIzq' en árbol vacío");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoIzq(hijo);
    }

    @Test(expected = NullPointerException.class)
    public void testSetHijoIzqNull() {
        System.out.println("Test 'setHijoIzq' con parámetro null");
        ArbolBinario<Integer> hijo = null;
        ArbolBinario<Integer> instance = hoja3;
        instance.setHijoIzq(hijo);
    }

    @Test
    public void testSetHijoIzqTrue() {
        System.out.println("Test 'setHijoIzq' en árbol 'hoja3'");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(2, vacio, vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7, new EnlazadoArbolBinario<>(2, vacio, vacio), vacio);
        instance.setHijoIzq(hijo);
        assertTrue(identicos(instance, expResult));
    }

    @Test
    public void testSetHijoIzqFalse() {
        System.out.println("Test 'setHijoIzq' en árbol 'raiz'");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(2, vacio, vacio);
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7, new EnlazadoArbolBinario<>(2, vacio, vacio), vacio);
        instance.setHijoIzq(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of setHijoDer method, of class EnlazadoArbolBinario.
     */
    @Test(expected = ArbolVacioExcepcion.class)
    public void testSetHijoDer() {
        System.out.println("Test 'setHijoDer' en árbol vacío");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(3, vacio, vacio);
        ArbolBinario<Integer> instance = vacio;
        instance.setHijoDer(hijo);
    }

    @Test(expected = NullPointerException.class)
    public void testSetHijoDerNull() {
        System.out.println("Test 'setHijoDer' con parámetro null");
        ArbolBinario<Integer> hijo = null;
        ArbolBinario<Integer> instance = hoja3;
        instance.setHijoDer(hijo);
    }

    @Test
    public void testSetHijoDerTrue() {
        System.out.println("Test 'setHijoDer' en árbol 'hoja3'");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(2, vacio, vacio);
        ArbolBinario<Integer> instance = hoja3;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7, vacio, new EnlazadoArbolBinario<>(2, vacio, vacio));
        instance.setHijoDer(hijo);
        assertTrue(identicos(instance, expResult));
    }

    @Test
    public void testSetHijoDerFalse() {
        System.out.println("Test 'setHijoDer' en árbol 'raiz'");
        ArbolBinario<Integer> hijo = new EnlazadoArbolBinario<>(2, vacio, vacio);
        ArbolBinario<Integer> instance = raiz;
        ArbolBinario<Integer> expResult = new EnlazadoArbolBinario<>(7, new EnlazadoArbolBinario<>(2, vacio, vacio), vacio);
        instance.setHijoDer(hijo);
        assertFalse(identicos(instance, expResult));
    }

    /**
     * Test of suprimir method, of class EnlazadoArbolBinario.
     */
    @Test
    public void testSuprimir() {
        System.out.println("Test 'suprimir' en árbol 'raiz'");
        ArbolBinario<Integer> instance = raiz;
        instance.suprimir();
        assertTrue(identicos(instance, vacio));
    }
    
}
