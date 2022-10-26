

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import static datos.conexion.close;
import static datos.conexion.getConnecction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author EL NOVIO DE LA HERAMANA DE GON
 */
public class Usauario_dao {
    private static final String SQL_SELECT ="SELECT * FORM usuario ";
    
    
    
    
    
    public List<Usuario> seleccionar_visualizar()throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        conn = getConnecction(); 
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int idusuario = rs.getInt("idusuario");
            String contraseña = rs.getString("contraseña");
            String nombre = rs.getString("nombre");
            usuarios.add(new Usuario(idusuario,contraseña,nombre));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return usuarios;
    
    }
    
    
}
