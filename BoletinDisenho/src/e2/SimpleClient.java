/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class SimpleClient implements Observer {
    
    String name;
    float closevalue;
    
    @Override
    public void update(Observable o, Object arg) {
        Stock stk = (Stock) o;
        name = stk.getName();
        closevalue = stk.getClosingvalue();
        System.out.println("Name: " + name);
        System.out.println("Price: " + closevalue);
    }
    
}
