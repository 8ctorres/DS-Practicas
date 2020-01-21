/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class StockTest {
    
    Stock stonk = new Stock("APPL",268.48f, 300f, 200f, 50000);
    SimpleClient simple = new SimpleClient();
    DetailedClient detailed = new DetailedClient();
    @Before
    public void init() {
        stonk.addObserver(simple);
        stonk.addObserver(detailed);
    }
    
    @Test
    public void testDetailed() {
        stonk.updateStock(223f,300f,100f,23456);
        assertEquals(223f, detailed.closingvalue, 0.1f);
        assertEquals(300f,detailed.maximum, 0.1f);
        assertEquals(100f,detailed.minimum, 0.1f);
        assertEquals(23456,detailed.volume, 0.1f);
    }
    
    @Test
    public void testSimple(){
        stonk.updateStock(34f, 1f, 500f, 34);
        assertEquals(34f, simple.closevalue, 0.1f);
        stonk.updateStock(37f, 0f, 1000f, 2);
        assertEquals(37f, simple.closevalue, 0.1f);
    }
}
