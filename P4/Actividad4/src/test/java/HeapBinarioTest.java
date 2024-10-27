/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Arboles_TADs.HeapBinario;
import Excepciones.HeapVacioExcepcion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ismael (Conde)²
 */
public class HeapBinarioTest {
    
    HeapBinario<Integer> heapVacio = new HeapBinario<>(); 
    HeapBinario<Integer> heapPrueba = new HeapBinario<>(); 
     	  
      
    @Before
    public void setUp() throws Exception {
        heapPrueba.insertar(8);
        heapPrueba.insertar(6);
        heapPrueba.insertar(5);
        heapPrueba.insertar(14);
        heapPrueba.insertar(1);
        heapPrueba.insertar(3);
        heapPrueba.insertar(12);
        heapPrueba.insertar(9);
        heapPrueba.insertar(7);
        heapPrueba.insertar(13);
        heapPrueba.insertar(2);
    }
    /**
     * Test of esVacio method, of class HeapBinario.
     */
    
    @Test
    public void testEsVacioTrue() {
        System.out.println("Test 'esVacio' sobre un heap vacÃ­o");
        boolean expResult = true;
        boolean result = heapVacio.esVacio();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEsVacioFalse() {
        System.out.println("Test 'esVacio' sobre heapPrueba");
        boolean expResult = false;
        boolean result = heapPrueba.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of recuperarMax method, of class HeapBinario.
     */
    @Test(expected=HeapVacioExcepcion.class)
    public void testRecuperarVacio() {
        System.out.println("Test 'recuperarMax' sobre heap vacÃ­o");
        Integer result = heapVacio.recuperarMax();
    }
    @Test
    public void testRecuperar() {
        System.out.println("Test 'recuperarMax' sobre heapPrueba");
        Integer result = heapPrueba.recuperarMax();
        Integer expResult = 8;
        assertEquals(expResult, result);
    }
    /**
     * Test of suprimirMax method, of class HeapBinario.
     */
    @Test (expected=HeapVacioExcepcion.class)
    public void testSuprimirVacio() {
        System.out.println("Test 'suprimirMax' sobre heap vacio");
        Integer result = heapVacio.suprimirMax();
    }
    @Test 
    public void testSuprimir() {
        System.out.println("Test 'suprimirMax' sobre heapPrueba");
        Integer expResult = 14;
        Integer result = heapPrueba.suprimirMax();
        result = heapPrueba.suprimirMax();
        result = heapPrueba.suprimirMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertar method, of class HeapBinario.
     */
    @Test
    public void testInsertarVacio() {
        System.out.println("Test 'insertar' sobre heap vacÃ­o");
        Integer e = 1;
        heapVacio.insertar(e);
        Integer result = heapVacio.recuperarMax();
        assertEquals(e, result);    
    }
    @Test
    public void testInsertar() {
        System.out.println("Test 'insertar' sobre heapPrueba");
        Integer e = 8;
        heapPrueba.insertar(e);
        Integer result = heapPrueba.recuperarMax();
        assertEquals(e, result);    
    }
    
    // para el ejercicio 2
 
    /**
     * Test of introducir method, of class HeapBinario.
     */
    @Test
    public void testIntroducirVacio() {
        System.out.println("Test 'introducir' sobre heap vacÃ­o");
        Integer e = 1;
        heapVacio.introducir(e);
        Integer result = heapVacio.recuperarMax();
        assertEquals(e, result); 
    }
    @Test
    public void testIntroducir() {
        System.out.println("Test 'introducir' sobre heapPrueba");
        Integer e = 8;
        heapPrueba.introducir(15);
        Integer result = heapPrueba.recuperarMax();
        assertEquals(e, result); 
    }

    /**
     * Test of arreglarHeap method, of class HeapBinario.
     */
    @Test
    public void testArreglarHeap() {
        System.out.println("Test 'arreglarHeap' sobre heapPrueba");
        heapPrueba.introducir(18);
        heapPrueba.introducir(19);
        heapPrueba.introducir(20);
        heapPrueba.arreglarHeap();
        Integer result = heapPrueba.recuperarMax();
        Integer e = 20;
        assertEquals(e, result);
    }
    
}
