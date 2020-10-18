/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Utilidades.Conexion;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author reant
 */
public class DAOLogin extends Conexion{
    
    public List<String> listUsuarios() throws ClassNotFoundException, SQLException{
        List<String> lista = new ArrayList<>();
        conex = getConexion();
        pstm = conex.prepareStatement("SELECT usuario FROM LOGIN");
        rsset = pstm.executeQuery();
        
        while(rsset.next()){
            String usuario = rsset.getString(1);
            lista.add(usuario);
        }
        conex.close();
        pstm.close();
        rsset.close();
        return lista;
    }
    public boolean VerificarContraseña(String usuario,String passw) throws ClassNotFoundException{
        String contra = null;
        try {
            conex = getConexion();
            pstm = conex.prepareStatement("SELECT * FROM LOGIN WHERE usuario = '"+usuario+"'");
            rsset = pstm.executeQuery();
            while(rsset.next()){
                contra = rsset.getString("contrasenia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conex.close();
                pstm.close();
                rsset.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (contra.equals(passw));           
    } 
}
