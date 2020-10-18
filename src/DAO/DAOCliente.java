/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Utilidades.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reant
 */
public class DAOCliente extends Conexion implements ICRUDS<Cliente>{

    private String sql = null;
    @Override
    public void Insertar(Cliente objetoT) {
        sql = "INSERT INTO CLIENTE (nombre,apellido,telefono) VALUES ";
        sql = sql.concat("('"+objetoT.getNombre()+"','"+objetoT.getApellido()+"','"+objetoT.getTelefono()+"')");
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Editar(Cliente objetoT) {
        int idCli = objetoT.getIdCliente();
        String nombre = objetoT.getNombre();
        String apellido = objetoT.getApellido();
        String telefono = objetoT.getTelefono();
        if(telefono.length()>9) telefono=telefono.substring(0, 9);
        
        sql = "UPDATE CLIENTE SET nombre='"+nombre+"',apellido='"+apellido+"',telefono='"+telefono+"' WHERE idCliente="+idCli;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    @Override
    public void Eliminar(int ID) {
        sql = "DELETE FROM CLIENTE WHERE idCliente = "+ID;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }

    @Override
    public Cliente BuscarporID(int ID) {
        sql = "SELECT * FROM CLIENTE WHERE idCliente="+ID;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            rsset.next();
            Cliente retorno = new Cliente(ID, rsset.getString(2), rsset.getString(3), rsset.getString(4));
            return retorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return null;
    }

    public Cliente BuscarporNombre(String nombre,String apellido) {
        sql = "SELECT * FROM CLIENTE WHERE nombre='"+nombre+"' AND apellido='"+apellido+"'";
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            rsset.next();
            Cliente retorno = new Cliente(rsset.getInt(1), rsset.getString(2), rsset.getString(3), rsset.getString(4));
            return retorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return null;
    }
    
    @Override
    public List<Cliente> Listar() {
        sql = "SELECT * FROM CLIENTE";
        List<Cliente> lista = new ArrayList<>();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            while(rsset.next()){
                Cliente n = new Cliente (rsset.getInt(1),rsset.getString(2),rsset.getString(3),rsset.getString(4));
                lista.add(n);
            }
            return lista;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();;
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }    
}
