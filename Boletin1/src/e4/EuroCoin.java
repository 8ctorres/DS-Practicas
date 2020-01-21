/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

import java.util.Objects;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */

public class EuroCoin {
    private int valor;
    private ColoresMonedas color;
    private Countries pais;
    private String diseño;
    private int año;

    public EuroCoin(int valor,Countries pais, String diseño, int año){
        switch (valor){
            case 1: {
                this.valor = 1;
                this.color = ColoresMonedas.BRONCE;
                break;}
            case 2: {
                this.valor = 2;
                this.color = ColoresMonedas.BRONCE;
                break;}
            case 5: {
                this.valor = 5;
                this.color = ColoresMonedas.BRONCE;
                break;}
            case 10: {
                this.valor = 10;
                this.color = ColoresMonedas.ORO;
                break;}
            case 20: {
                this.valor = 20;
                this.color = ColoresMonedas.ORO;
                break;}
            case 50: {
                this.valor = 50;
                this.color = ColoresMonedas.ORO;
                break;}
            case 100: {
                this.valor = 100;
                this.color = ColoresMonedas.OROPLATA;
                break;}
            case 200: {
                this.valor = 200;
                this.color = ColoresMonedas.OROPLATA;
                break;}
            default: throw new IllegalArgumentException();
        }
        this.diseño = diseño;
        this.pais = pais;
        if (año>=2000) {
            this.año = año;
        }
        else {throw new IllegalArgumentException();}
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.valor;
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.pais);
        hash = 67 * hash + Objects.hashCode(this.diseño);
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
        if (!(obj instanceof EuroCoin)) {
            return false;
        }
        final EuroCoin other = (EuroCoin) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.diseño, other.diseño)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.pais != other.pais) {
            return false;
        }
        return true;
    }

    public int getValor(){
        return this.valor;
    }

    public ColoresMonedas getColor(){
        return this.color;
    }
    
    public Countries getPais(){
        return this.pais;
    }

    public String getDiseño(){
        return this.diseño;
    }

    public int getAño(){
        return this.año;
    }
}
