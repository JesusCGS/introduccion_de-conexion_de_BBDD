

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
    private static final String SQL_INSERT ="INSERT INTO usuario(contraseña,nombre)VALUES (?,?)";
    private static final String SQL_UPDATE ="UPDATE usuario SET contraseña=?,nombre=? WHERE idusario=?";
    private static final String SQL_DELETE ="DELETE FROM usuario WHERE idusuario=? ";
    
    
    
    
    
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
    public int insertar(Usuario usuario){

            //declaro e incializo mis variables
             Connection conn = null;
             PreparedStatement stm = null;
             int registros=0;
              try {  
            //1. establecer la conexion
                conn = getConnecction();
            //2. reparo mi instrucion para ejecutarla contra la base de datos 
                stm= conn.prepareStatement(SQL_INSERT);
            //asignar los valores de los ? de la consulta    
                stm.setString(1,usuario.getContraseña());
                stm.setString(2,usuario.getNombre());
                
                

            //3.ejcuto el array
                registros= stm.executeUpdate();

              }catch(SQLException ex){
                  ex.printStackTrace(System.out);

              }finally{
                 try {
                     close(stm);
                     close(conn);
                 } catch (SQLException ex) {
                      ex.printStackTrace(System.out);
                 }
              }
              return registros;
    }
    
    public int actualizar(Usuario usuario){

            //declaro e incializo mis variables
             Connection conn = null;
             PreparedStatement stm = null;
             int registros=0;
              try {  
            //1. establecer la conexion
                conn = getConnecction();
            //2. reparo mi instrucion para ejecutarla contra la base de datos 
                stm= conn.prepareStatement(SQL_UPDATE);
            //asignar los valores de los ? de la consulta    
                stm.setString(1,usuario.getContraseña());
                stm.setString(2,usuario.getNombre());
                stm.setInt(3,usuario.getIdusario());

            //3.ejcuto el array
                registros= stm.executeUpdate();

              }catch(SQLException ex){
                  ex.printStackTrace(System.out);

              }finally{
                 try {
                     close(stm);
                     close(conn);
                 } catch (SQLException ex) {
                      ex.printStackTrace(System.out);
                 }
              }
              return registros;
    }
    public int delete (Usuario usuario){
        Connection conn = null;
        PreparedStatement stm = null;
                 int registros=0;
                  try{  
                       conn = getConnecction();
                       stm= conn.prepareStatement(SQL_DELETE);
                       stm.setInt(1, usuario.getIdusario());
                       registros = stm.executeUpdate();
                       
                  }catch(SQLException ex){
                  ex.printStackTrace(System.out);
                  }finally{
                 try {
                     close(stm);
                     close(conn);
                 } catch (SQLException ex) {
                      ex.printStackTrace(System.out);
                 }
              }
              return registros;
    }
    

    
    
}
