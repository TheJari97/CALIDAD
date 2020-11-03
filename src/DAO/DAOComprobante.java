/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidades.Comprobante;
import Entidades.Venta;
import Utilidades.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DAOComprobante extends Conexion implements ICRUDS<Comprobante>{
    private String sql;

    @Override
    public void Insertar(Comprobante objetoT) {
        DAOVentas v=new DAOVentas();
        sql ="INSERT INTO comprobante (venta_id,documento,razonsocial,fecha,total) VALUES ('"+v.VerUltimoNumVenta()
                +"','"+objetoT.getDocumento()+"','"+objetoT.getRazonsocial()+"','"+objetoT.getFecha()+"','"+objetoT.getTotal()+"')";
        try {
            conex = getConexion();
            pstm = conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Editar(Comprobante objetoT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comprobante BuscarporID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comprobante> Listar() {
       sql = "SELECT * FROM Comprobante WHERE CHARACTER_LENGTH(documento)=8";
        List<Comprobante> lista = new ArrayList<>();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            while(rsset.next()){
                DAOVentas pr=new DAOVentas();
                Venta v=new Venta();
                v=pr.BuscarporID(rsset.getInt(2));
                Comprobante n = new Comprobante(rsset.getInt(1),null,rsset.getString(5), v, rsset.getString(4), rsset.getString(3), rsset.getDouble(6));
                lista.add(n);
            }
            return lista;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                rsset.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public List<Comprobante> ListarFa() {
       sql = "SELECT * FROM Comprobante WHERE CHARACTER_LENGTH(documento)=11";
        List<Comprobante> lista = new ArrayList<>();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            while(rsset.next()){
                DAOVentas pr=new DAOVentas();
                Venta v=new Venta();
                v=pr.BuscarporID(rsset.getInt(2));
                Comprobante n = new Comprobante(rsset.getInt(1),null,rsset.getString(5), v, rsset.getString(4), rsset.getString(3), rsset.getDouble(6));
                lista.add(n);
            }
            return lista;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                rsset.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
