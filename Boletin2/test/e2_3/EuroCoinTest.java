/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_3;

import java.util.Comparator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 * 
 */

public class EuroCoinTest {
    EuroCoin moneda1 = new EuroCoin(200,Countries.ES,"Juan Carlos",2001);        
    EuroCoin moneda2 = new EuroCoin(100,Countries.ES,"Juan Carlos",2003);        
    EuroCoin moneda3 = new EuroCoin(200,Countries.AT,"Juan Carlos",2003);        
    EuroCoin moneda4 = new EuroCoin(200,Countries.ES,"Felipe",2003);           
    EuroCoin moneda5 = new EuroCoin(200,Countries.ES,"Juan Carlos",2002);
    EuroCoin moneda6 = new EuroCoin(1,Countries.ES,"AAA",2002);
    EuroCoin moneda7 = new EuroCoin(2,Countries.FR,"BBB",2002);
    EuroCoin moneda8 = new EuroCoin(5,Countries.IT,"CCC",2002);
    EuroCoin mo = new EuroCoin(1,Countries.DE,"Cruz",2019);
    
    @Test
    public void testCompareTo(){
        assertTrue(moneda1.compareTo(moneda2) >0);
        assertTrue(moneda1.compareTo(moneda3) >0);
        assertTrue(moneda1.compareTo(moneda4) >0);
        assertTrue(moneda1.compareTo(moneda5) ==0);
        assertTrue(moneda2.compareTo(moneda3) <0);
        assertTrue(moneda2.compareTo(moneda4) <0);
        assertTrue(moneda2.compareTo(moneda5) <0);
        assertTrue(moneda3.compareTo(moneda4) <0);
        assertTrue(moneda3.compareTo(moneda5) <0);
        assertTrue(moneda4.compareTo(moneda5) <0);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void monedade3euros(){
        new EuroCoin(300, Countries.FR, "Luis XVI", 2016);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void monedaAntigua(){
        new EuroCoin(200, Countries.GR, "ola", 1492);
    }
    
    @Test
    public void testCompareA() {
        Comparator<EuroCoin> compalt = new CompAlternativo();
        assertTrue(compalt.compare(moneda1,moneda2) <0);
        assertTrue(compalt.compare(moneda1,moneda3) >0);
        assertTrue(compalt.compare(moneda1,moneda4) <0);
        assertTrue(compalt.compare(moneda1,moneda5) <0);
        assertTrue(compalt.compare(moneda2,moneda3) >0);
        assertTrue(compalt.compare(moneda2,moneda4) >0);
        assertTrue(compalt.compare(moneda2,moneda5) >0);
        assertTrue(compalt.compare(moneda2,moneda2)==0);
        assertTrue(compalt.compare(moneda3,moneda4) <0);
        assertTrue(compalt.compare(moneda3,moneda5) <0);
        assertTrue(compalt.compare(moneda4,moneda5) >0);
        assertTrue(compalt.compare(moneda2,moneda6) <0);
    }
    
    @Test
    public void testtoString() {
        assertEquals(moneda6.toString(),"Valor : 1   Pais : Spain   Diseño : AAA   Año : 2002");
    }
    
    @Test
    public void testEqualsAndHashCode() {
        assertFalse(moneda1.equals(moneda2));
        assertTrue(moneda1.equals(moneda1));
        EuroCoin tp = new EuroCoin(200,Countries.ES,"Juan Carlos",2001);
        assertTrue(moneda1.equals(tp));
        assertTrue(moneda1.hashCode() == tp.hashCode());
        assertFalse(moneda1.hashCode() == moneda3.hashCode());
        Object o = new Object();
        assertFalse(moneda1.equals(o));
        Object o2 = null;
        assertFalse(moneda1.equals(o2));
        assertFalse(moneda1.equals(moneda3));
        assertFalse(moneda1.equals(moneda4));
        assertEquals(ColoresMonedas.BRONCE, moneda7.getColor());
        assertEquals("CCC",moneda8.getDiseño());
    }
}
