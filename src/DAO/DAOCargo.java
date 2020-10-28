/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entidades.Cargo;
import Utilidades.Conexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class DAOCargo extends Conexion implements ICRUDS<Cargo>{
    private String sql;
    
    @Override
    public void Insertar(Cargo objetoT) {
        sql = "INSERT INTO Cargo (cargo) VALUES ";
        sql = sql.concat("('"+objetoT.getCargo()+"')");
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
    public void Editar(Cargo objetoT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargo BuscarporID(int ID) {
        sql = "SELECT * FROM CARGO WHERE idcargo="+ID;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            rsset.next();
            
            Cargo retorno = new Cargo(ID,rsset.getString("cargo"));
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
    public List<Cargo> Listar() {
        sql = "SELECT * FROM Usuario";
        List<Cargo> lista = new ArrayList<>();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            while(rsset.next()){
                Cargo n = new Cargo(rsset.getInt(1),rsset.getString(2));
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
