package e2_3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author carlos.torres
 * @author d.s.vega
 * 
 */
public class EuroCoinCollectionTest {
        EuroCoinCollection colecc = new EuroCoinCollection();
        EuroCoin moneda1 = new EuroCoin(200,Countries.AT,"Juan Carlos",2001);        
        EuroCoin moneda2 = new EuroCoin(100,Countries.ES,"Juan Carlos",2002);        
        EuroCoin moneda3 = new EuroCoin(50,Countries.AT,"Juan Carlos",2003);        
        EuroCoin moneda4 = new EuroCoin(20,Countries.ES,"Felipe",2004);           
        EuroCoin moneda5 = new EuroCoin(10,Countries.ES,"Juan Carlos",2005); 
        EuroCoin moneda6 = new EuroCoin(1,Countries.AT,"Cruz",2006);
        
        @Before
        public void setUp(){
            colecc.insertCoin(moneda1);
            colecc.insertCoin(moneda2);
            colecc.insertCoin(moneda3);
            colecc.insertCoin(moneda4);
            colecc.insertCoin(moneda5);
            colecc.insertCoin(moneda6);
        }
        

        @Test
        public void testIt(){
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            it.next();
            it.next();
            it.next();
            it.next();
            it.next();
            assertFalse(it.hasNext());
        }
        
        @Test
        public void testRemove(){
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            it.remove();
            it.next();
            it.remove();
            it.next();
            it.remove();
            assertTrue(it.hasNext());
            it.next();
            it.remove();
            it.next();
            it.remove();
            it.next();
            it.remove();
            assertFalse(it.hasNext());
            assertEquals(0,colecc.numCoins());
        }
        
        @Test
        public void insertTest() {
            EuroCoinCollection tmp = new EuroCoinCollection();
            Iterator<EuroCoin> it = tmp.iterator();
            assertFalse(it.hasNext());
            tmp.insertCoin(moneda1);
            Iterator<EuroCoin> it2 = tmp.iterator();
            assertTrue(it2.hasNext());
            it2.next();
            assertFalse(it2.hasNext());
        }
        
        @Test (expected = IllegalStateException.class)
        public void testFailRemove(){
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            it.remove();
            it.remove();
        }
        
        @Test
        public void testPrint(){
            Iterator<EuroCoin> it = colecc.iterator();
            System.out.println("Test Print :");
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println("");
        }
        
        @Test (expected = NoSuchElementException.class)
        public void testFailPrint(){
            Iterator<EuroCoin> it = colecc.iterator();
            System.out.println("Test Print Fail :");
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
            System.out.println(it.next().toString());
        }
        
        @Test //No realmente necesarios ya que fueron testeados en B1
        public void testForCoverage() {
            assertEquals(381,colecc.value());
            assertTrue(colecc.hasCoin(moneda1));
        }
        
        @Test
        public void testConditionalIteration() {
            colecc.setIterationCountry(Countries.AT);
            Iterator<EuroCoin> it = colecc.iterator();
            assertFalse(it.next().getPais() != Countries.AT);
            assertTrue(it.hasNext());
            assertFalse(it.next().getPais() != Countries.AT);
            assertFalse(it.next().getPais() != Countries.AT);
            assertFalse(it.hasNext());
            colecc.setIterationCountry(Countries.ES);
            Iterator<EuroCoin> it2 = colecc.iterator();
            assertFalse(it2.next().getPais() != Countries.ES);
            assertFalse(it2.next().getPais() != Countries.ES);
            assertFalse(it2.next().getPais() != Countries.ES);
            assertFalse(it2.hasNext());
            colecc.setIterationCountry(Countries.FR);
            Iterator<EuroCoin> it3 = colecc.iterator();
            assertFalse(it3.hasNext());
        }
        
        @Test
        public void testHasNextCondIt() {
            colecc.setIterationCountry(Countries.AT);
            Iterator<EuroCoin> it = colecc.iterator();
            assertFalse(it.next().getPais() != Countries.AT);
            assertTrue(it.hasNext());
            assertTrue(it.hasNext());
            assertTrue(it.hasNext());
            assertFalse(it.next().getPais() != Countries.AT);
            assertTrue(it.hasNext());
            assertFalse(it.next().getPais() != Countries.AT);
            assertFalse(it.hasNext());
            assertFalse(it.hasNext());
        };
        
        @Test
        public void testRemoveCondIt() {
            colecc.setIterationCountry(Countries.AT);
            Iterator<EuroCoin> it = colecc.iterator();
            assertFalse(it.next().getPais() != Countries.AT);
            it.remove();
            assertFalse(it.next().getPais() != Countries.AT);
            it.remove();
            assertFalse(it.next().getPais() != Countries.AT);
            it.remove();
            assertFalse(it.hasNext());
        }
        
        @Test (expected = NoSuchElementException.class)
        public void testNextCondIt() {
            colecc.setIterationCountry(Countries.BE);
            Iterator<EuroCoin> it = colecc.iterator();  
            System.out.println(it.next().toString());
        }
         
        
        @Test (expected = ConcurrentModificationException.class)
        public void testConcurrentMod() {
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            colecc.removeCoin(moneda3);
            it.next();
        }
        
        @Test
        public void testSort() {
            colecc.sort(null);
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            for (EuroCoin e : colecc) {
                if (!it.hasNext()) break;
                assertTrue(e.compareTo(it.next()) < 0);
            }
            Comparator<EuroCoin> c = new CompAlternativo();
            colecc.sort(c);
            Iterator<EuroCoin> it2 = colecc.iterator();
            it2.next();
            for (EuroCoin e : colecc) {
                if (!it2.hasNext()) break;
                assertTrue(c.compare(e,it2.next()) < 0);
            }
        }
        
        @Test (expected = ConcurrentModificationException.class)
        public void TestIteratorDiffCountries(){
            System.out.println("\nTestIteratorCountries");
            colecc.setIterationCountry(Countries.ES);
            Iterator<EuroCoin> it_es = colecc.iterator();
            colecc.setIterationCountry(Countries.AT);
            Iterator<EuroCoin> it_at = colecc.iterator();
            System.out.println(it_es.next().toString());
            System.out.println(it_es.next().toString());
            System.out.println(it_at.next().toString());
            it_at.remove();
            System.out.println(it_at.next().toString());
            System.out.println(it_es.next().toString());
        }
        
        @Test (expected = ConcurrentModificationException.class)
        public void TestModificationIter(){
            colecc.setIterationCountry(Countries.ES);
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            it.next();
            colecc.insertCoin(new EuroCoin(50, Countries.IT, "presidente de italia", 2007));
            it.next();
        }
        
        @Test (expected = NoSuchElementException.class)
        public void TestItNoElem(){
            Iterator<EuroCoin> it = colecc.iterator();
            it.next();
            it.next();
            it.next();
            it.next();
            it.next();
            it.next();
            it.next();
        }
}
