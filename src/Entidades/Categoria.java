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
public class Categoria {
    private int idCategoria;
    private String Categoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String Categoria) {
        this.idCategoria = idCategoria;
        this.Categoria = Categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
}
