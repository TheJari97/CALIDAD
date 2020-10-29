/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cargo;
import Entidades.Usuario;
import Utilidades.Conexion;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author reant
 */
public class DAOUsuarios extends Conexion implements ICRUDS<Usuario>{

    private String sql;
    
    @Override
    public void Insertar(Usuario objetoT) {
        try {
            sql="INSERT INTO Usuario (nombre,apellido,documento,edad,telefono,password,cargo_id) VALUES ('"+objetoT.getNombre()+"','"+objetoT.getApellido()
                    +"','"+objetoT.getDocumento()+"','"+objetoT.getEdad()+"','"+objetoT.getTelefono()+"','"+objetoT.getPassword()+"','"+objetoT.getCargo().getIdcargo()+"')";
            
            conex=getConexion();
            pstm= conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Editar(Usuario objetoT) {
        try {
            sql="UPDATE USUARIO SET "
                    + "nombre='"+objetoT.getNombre()+"',"
                    + "apellido='"+objetoT.getApellido()+"'"
                    + "documento='"+objetoT.getDocumento()+"'"
                    + "edad='"+objetoT.getEdad()+"'"
                    + "telefono='"+objetoT.getTelefono()+"'"
                    + "password='"+objetoT.getPassword()+"'"
                    + " WHERE codEmpleado="+objetoT.getIdusuario();
            
            conex=getConexion();
            pstm= conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void Eliminar(int ID) {
        try {
            sql="DELETE FROM Usuario WHERE "
                    + "idusaurio="+ID;
            
            conex=getConexion();
            pstm= conex.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Usuario BuscarporID(int ID) {
        try {
            Usuario emp = null;
            sql="SELECT * FROM Usuario WHERE codEmpleado="+ID;
            
            conex=getConexion();
            pstm= conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            rsset.next();
            emp = new Usuario(ID,rsset.getString("nombre") , rsset.getString("apellido"), rsset.getString("documento"), 
                    rsset.getInt("edad"), rsset.getString("telefono"), rsset.getString("password"), (Cargo) rsset.getObject("cargo_id"));
     
            return emp;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                rsset.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public Usuario BuscarporNombre(String Nombre, String Apellido) {
        try {
            sql="SELECT * FROM USUrio WHERE nombre='"+Nombre+"' AND apellido='"+Apellido+"'";
            
            conex=getConexion();
            pstm=conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            
            Usuario temp = null;
            while(rsset.next()){
                temp = new Usuario(rsset.getInt(1), Nombre, Apellido);
            }
            return temp;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                rsset.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public List<Usuario> Listar() {
        try {
            List<Usuario> lista = new ArrayList<>();
            sql="SELECT * FROM Usuario";
            
            conex=getConexion();
            pstm= conex.prepareStatement(sql);
            rsset=pstm.executeQuery();
            while(rsset.next()){
                Usuario aux = new Usuario(rsset.getInt(1), rsset.getString(2), rsset.getString(3),rsset.getString(4),
                        rsset.getInt(5),rsset.getString(6),rsset.getString(7), null);
                lista.add(aux);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                rsset.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return null;
    }

}
