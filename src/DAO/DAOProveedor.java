/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Categoria;
import Utilidades.Conexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reant
 */
public class DAOProveedor extends Conexion implements ICRUDS<Categoria>{

    private String sql;
    @Override
    public void Insertar(Categoria objetoT) {
        sql = "INSERT INTO PROVEEDOR (Nombre) VALUES ";
        sql = sql.concat("('"+objetoT.getNombre()+"')");
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Editar(Categoria objetoT) {
        try {
            int idPro = objetoT.getIdProveedor();
            String nombre = objetoT.getNombre();
            sql = "UPDATE PROVEEDOR SET Nombre='"+nombre+"' WHERE idProveedor="+idPro;
            
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Eliminar(int ID) {
        sql = "DELETE FROM PROVEEDOR WHERE idProveedor = "+ID;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }

    @Override
    public Categoria BuscarporID(int ID) {
        sql = "SELECT * FROM PROVEEDOR WHERE idProveedor="+ID;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            rsset.next();
            
            Categoria retorno = new Categoria(ID,rsset.getString("Nombre"));
            return retorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return null;
    }

    public Categoria BuscarporNombre(String Nombre){
        sql = "SELECT * FROM PROVEEDOR WHERE Nombre='"+Nombre+"'";
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            rsset.next();
            
            Categoria retorno = new Categoria(rsset.getInt(1),Nombre);
            return retorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return null;
        
    }
    @Override
    public List<Categoria> Listar() {
        sql = "SELECT * FROM PROVEEDOR";
        List<Categoria> lista = new ArrayList<>();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            while(rsset.next()){
                Categoria n = new Categoria (rsset.getInt(1),rsset.getString(2));
                lista.add(n);
            }
            return lista;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
