    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.Objects;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */

public final class EuroCoin implements Comparable<EuroCoin>{
    private final int valor;
    private final ColoresMonedas color;
    private final Countries pais;
    private final String diseño;
    private final int año;

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
    
    public EuroCoin(int valor){
        this(valor, Countries.ES, "Felipe VI", 2019);
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

    @Override
    public int compareTo(EuroCoin moneda) { //esta version de compareTo hace que
                                            //las monedas se ordenen de mayor a menor valor
        int temp;
        temp = moneda.getValor() - this.valor;
        if (temp!=0) return temp;
        temp = this.pais.toString().compareTo(moneda.pais.toString());
        if (temp!=0) return temp;
        temp = this.diseño.compareTo(moneda.diseño);
        return temp;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Valor : ");
        sb.append(valor);
        sb.append("   Pais : ");
        sb.append(this.pais.toString());
        sb.append("   Diseño : ");
        sb.append(this.diseño);
        sb.append("   Año : ");
        sb.append(this.año);
        return new String(sb);
    }
}
