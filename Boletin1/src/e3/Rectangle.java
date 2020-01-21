/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e3;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
public class Rectangle {

    private int base;
    private int height;

    public Rectangle(int base, int height){
        if (base <= 0) throw new IllegalArgumentException("Base cannot be negative or zero");
        if (height <= 0) throw new IllegalArgumentException("Height cannot be negative or zero");
        this.base = base;
        this.height = height;
    }

    public Rectangle(Rectangle r){
        this.base = r.base;
        this.height = r.height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        if (base <= 0) throw new IllegalArgumentException("Base cannot be negative or zero");
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("Height cannot be negative or zero");
        this.height = height;
    }

    public boolean isSquare(){
        return (this.base == this.height);
    }

    public int area(){
        return (this.base*this.height);
    }
    
    public int perimeter() {
        return (2*this.base + 2*this.height);
    }

    public double diagonal(){
        double base2 = this.base*this.base;
        double h2 = this.height*this.height;
        double diag = base2+h2;
        diag = Math.sqrt(diag);
        return diag;
    }

    public void turn(){
        int tmp;
        tmp = this.height;
        this.height = this.base;
        this.base = tmp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.base * this.height);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Rectangle r = (Rectangle) obj;
        if ((this.base == r.getHeight()) && (this.height == r.getBase())){
            return true;
        }
        if ((this.base == r.getBase()) && (this.height == r.getHeight())){
            return true;
        }
        return false;
    }
    
    public void putHorizontal() {
        if (this.base < this.height) {
            this.turn();
        }
    }

    public void putVertical() {
        if (this.base > this.height) {
            this.turn();
        }
    }
}
