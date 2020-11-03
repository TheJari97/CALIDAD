/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author reant
 */
public class DET_Venta {
    private Venta v;
    private Producto p ;
    private int cantidad;
    private double precioN;

    public DET_Venta() {
    }

    public DET_Venta(Producto p, int cantidad) {
        this.p = p;
        this.cantidad = cantidad;
        updatePrecioN();
    }
    public DET_Venta(Venta v, Producto p, int cantidad, double precioN) {
        this.v = v;
        this.p = p;
        this.cantidad = cantidad;
        this.precioN = precioN;
        updatePrecioN();
    }

    public Venta getV() {
        return v;
    }

    public void setV(Venta v) {
        this.v = v;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioN() {
        return precioN;
    }

    public void setPrecioN(double precioN) {
        this.precioN = precioN;
    }
    
    private void updatePrecioN(){
        this.precioN = this.p.getPrecioUni() * this.cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.v);
        hash = 97 * hash + Objects.hashCode(this.p);
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precioN) ^ (Double.doubleToLongBits(this.precioN) >>> 32));
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DET_Venta other = (DET_Venta) obj;
        return true;
    }
    

}
