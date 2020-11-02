/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Producto;
import Entidades.Proveedor;
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
public class DAOProducto extends Conexion implements ICRUDS<Producto>{

    private String sql ;
    @Override
    public void Insertar(Producto pro) {
        sql ="INSERT INTO producto (proveedor_id,nombre,precio,cantidad,estado,fecha) VALUES ('"+pro.getProveedor().getIdproveedor()
                +"','"+pro.getProducto()+"','"+pro.getPrecioUni()+"','"+pro.getStock()+"','"+1+"','"+pro.getFecha()+"')";
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
    public void Editar(Producto pro) {
        sql = "UPDATE PRODUCTO SET "
                + "nombre='"+pro.getProducto()+"',"
                + "precio="+pro.getPrecioUni()+","
                + "cantidad="+pro.getStock()+","
                + "proveedor_id="+pro.getProveedor().getIdproveedor()+" "
                + "WHERE idproducto="+pro.getCodProducto();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    @Override
    public void Eliminar(int ID) {
        sql = "DELETE FROM PRODUCTO WHERE idproducto= "+ID;
        
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }

    @Override
    public Producto BuscarporID(int ID) {
        try {
            sql = "SELECT * FROM PRODUCTO WHERE idproducto="+ID;
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            rsset.next();
            
            DAOProveedor pr=new DAOProveedor();
            Proveedor p = new Proveedor();
            p=pr.BuscarporID(rsset.getInt(2));
            
            Producto retorno= new Producto(rsset.getInt(1), rsset.getString(3), rsset.getDouble(4), rsset.getInt(5), new Proveedor(rsset.getInt(2), p.getProveedor()), rsset.getString(7));
            return retorno;
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

    @Override
    public List<Producto> Listar() {
        sql = "SELECT * FROM PRODUCTO ";
        List<Producto> lista = new ArrayList<>();
        try {
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            while(rsset.next()){
                DAOProveedor pr=new DAOProveedor();
                Proveedor pro=new Proveedor();
                pro=pr.BuscarporID(rsset.getInt(2));
                Producto n = new Producto(rsset.getInt(1),rsset.getString(3), rsset.getDouble(4), rsset.getInt(5), new Proveedor(rsset.getInt(2), pro.getProveedor()), rsset.getString(7));
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
    
    public Producto BuscarporNombre(String descripcion){
        try {
            sql="SELECT * FROM PRODUCTO p INNER JOIN PROVEEDOR pr ON p.idProveedor=pr.idProveedor WHERE p.descripcion='"+descripcion+"'";
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            rsset.next();
            
            Producto retorno = new Producto(rsset.getInt(1),rsset.getString(2), rsset.getDouble(3), rsset.getInt(4),
                        new Proveedor(rsset.getInt(7), rsset.getString(8)), rsset.getString(6));
            
            return retorno;
        } catch (SQLException | ClassNotFoundException ex) {
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
