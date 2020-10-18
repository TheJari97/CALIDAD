/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author reant
 */
public interface ICRUDS<T> {
    public void Insertar(T objetoT);
    public void Editar(T objetoT);
    public void Eliminar(int ID);
    public T BuscarporID(int ID);
    public List<T> Listar();
}
