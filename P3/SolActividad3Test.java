
package gal.uvigo.esei.aed2.solactividad3;



import org.junit.Test;
import static org.junit.Assert.*;


public class SolActividad3Test {
    private static final ArbolBinario<Character> vacioChar = new EnlazadoArbolBinario<>();
    private static final ArbolBinario<Character> hoja2Char = new EnlazadoArbolBinario<>('5', vacioChar, vacioChar);
    private static final ArbolBinario<Character> hoja1Char = new EnlazadoArbolBinario<>('3', vacioChar, vacioChar);
    private static final ArbolBinario<Character> nodo1Char = new EnlazadoArbolBinario<>('6', hoja1Char, hoja2Char); 

    private static final ArbolBinario<Character> hoja4Char = new EnlazadoArbolBinario<>('1', vacioChar, vacioChar);
    private static final ArbolBinario<Character> hoja5Char = new EnlazadoArbolBinario<>('8', vacioChar, vacioChar);
    private static final ArbolBinario<Character> nodo2Char = new EnlazadoArbolBinario<>('2', hoja4Char, hoja5Char);
    private static final ArbolBinario<Character> arbolCamino = new EnlazadoArbolBinario<>('7', nodo1Char, nodo2Char);
    
    
    public static <E> boolean identicos (ArbolBinario<E> a, ArbolBinario<E> b){
        if (!a.esVacio() && !b.esVacio())
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        else return a.esVacio() && b.esVacio();
    }
    /**
     * Ejercicio a
     * Test of construir method, of class SolActividad3.
     */
    @Test
    public void testConstruir() {
        System.out.println("Test 'construir' a partir de recorridos '3' y '3'");
        ArbolBinario<Character> expResult = hoja1Char;
        ArbolBinario<Character> result = SolActividad3.construir("3","3");
        boolean eq = identicos(expResult, result);
        assertTrue(eq);
    }
    @Test
    public void testConstruir2() {
        System.out.println("Test 'construir' a partir de recorridos '7635218' y '3657128'");
        ArbolBinario<Character> expResult = arbolCamino;
        ArbolBinario<Character> result = SolActividad3.construir("7635218", "3657128");
        boolean eq = identicos(expResult, result);
        assertTrue(eq);
    }

     /**
     * Ejercicio b
     * Test of esCamino method, of class SolActividad2.
     */
    @Test
    public void testVacioEsCamino() {
        System.out.println("Test 'esCamino' con árbol vacío y camino vacio");
        boolean expResult = true;
        boolean result = SolActividad3.esCamino2(vacioChar, "");
        assertEquals(expResult, result);
    }
    @Test
    public void testNoEsCamino() {
        System.out.println("Test 'esCamino' con árbol 'arbolCamino' y camino '5'");
        boolean expResult = false;
        boolean result = SolActividad3.esCamino2(arbolCamino, "5");
        assertEquals(expResult, result);
    }
    @Test
    public void testEsCamino() {
        System.out.println("Test 'esCamino' con árbol 'arbolCamino' y camino '763'");
        boolean expResult = true;
        boolean result = SolActividad3.esCamino2(arbolCamino, "763");
        assertEquals(expResult, result);
    }
    @Test
    public void testEsCamino2() {
        System.out.println("Test 'esCamino' con árbol 'arbolCamino' y camino '721'");
        boolean expResult = true;
        boolean result = SolActividad3.esCamino2(arbolCamino, "721");
        assertEquals(expResult, result);
    }

    /**
     * Test of getPadre method, of class SolActividad3.
     */
    @Test
    public void testGetPadre() {
        System.out.println("Test 'getPadre' con arbolCamino y elemento 4");
        Character expResult = null;
        Character result = SolActividad3.getPadre(arbolCamino, '4');
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPadreRaiz() {
        System.out.println("Test 'getPadre' con arbolCamino y elemento 7");
        Character expResult = null;
        Character result = SolActividad3.getPadre(arbolCamino, '7');
        assertEquals(expResult, result);
    }
    @Test
    public void testGetPadreNodo() {
        System.out.println("Test 'getPadre' con arbolCamino y elemento 2");
        Character expResult = '7';
        Character result = SolActividad3.getPadre(arbolCamino, '2');
        assertEquals(expResult, result);
    }
    @Test
    public void testGetPadreHoja() {
        System.out.println("Test 'getPadre' con arbolCamino y elemento 1");
        Character expResult = '2';
        Character result = SolActividad3.getPadre(arbolCamino, '1');
        assertEquals(expResult, result);
    }
    
}