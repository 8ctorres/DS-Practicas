/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import java.util.Observable;

/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class Stock extends Observable {
    
    private final String name;
    private float closingvalue;
    private float maximum;
    private float minimum;
    private int volume;

    public Stock(String name, float close, float max, float min, int vol) {
        this.name = name;
        this.volume = vol;
        this.maximum = max;
        this.minimum = min;
        this.closingvalue = close;
    }
    
    public String getName() {
        return name;
    }

    public float getClosingvalue() {
        return closingvalue;
    }

    public float getMaximum() {
        return maximum;
    }

    public float getMinimum() {
        return minimum;
    }

    public int getVolume() {
        return volume;
    }
    
    public void updateStock(float close, float max, float min, int vol) {
        this.volume = vol;
        this.maximum = max;
        this.minimum = min;
        this.closingvalue = close;
        this.setChanged();
        this.notifyObservers();
    }
}
