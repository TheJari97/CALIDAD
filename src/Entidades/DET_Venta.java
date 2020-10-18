/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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

    public DET_Venta(Venta v, Producto p, int cantidad, double precioN) {
        this.v = v;
        this.p = p;
        this.cantidad = cantidad;
        this.precioN = precioN;
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

}
