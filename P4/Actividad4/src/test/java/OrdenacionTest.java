/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import es.uvigo.actividad4.Actividad4;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ismael (Conde)²
 */
public class OrdenacionTest {
    public OrdenacionTest() {
    }

    /**
     * Test of heapSort method, of class Ordenacion.
     */
    @Test
    public void testHeapSortVacio() {
        System.out.println("heapSort vacÃ­o");
        int[] elementos = {};
        int[] expResult = {};
        Actividad4.heapSort(elementos);
        assertTrue(Arrays.equals(elementos, expResult));
    }
    @Test
    public void testHeapSort1() {
        System.out.println("heapSort 1 elemento");
        int[] elementos = {23};
        int[] expResult = {23};
        Actividad4.heapSort(elementos);
        assertTrue(Arrays.equals(elementos, expResult));
    }
    @Test
    public void testHeapSort() {
        System.out.println("heapSort varios elementos");
        int[] elementos = {23,45,12,34,67,43,76,88,69,28,61};
        int[] expResult = {88,76,69,67,61,45,43,34,28,23,12};
        Actividad4.heapSort(elementos);
        assertTrue(Arrays.equals(elementos, expResult));
    }
}
