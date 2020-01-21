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
public class DetailedClient implements Observer {
    
    String name;
    float closingvalue;
    float maximum;
    float minimum;
    int volume;

    @Override
    public void update(Observable o, Object arg) {
        Stock stk = (Stock) o;
        this.closingvalue = stk.getClosingvalue();
        this.maximum = stk.getMaximum();
        this.minimum = stk.getMinimum();
        this.volume = stk.getVolume();
        this.name = stk.getName();
        
        System.out.println("Name: " + name);
        System.out.println("Closing Value: " + closingvalue);
        System.out.println("Minimum: "+ minimum);
        System.out.println("Maximum: "+ maximum);
        System.out.println("Volume: "+ volume);            
    }
}
