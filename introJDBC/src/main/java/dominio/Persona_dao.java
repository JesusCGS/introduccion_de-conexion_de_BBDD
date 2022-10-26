/*
 * CONJUNTO DE OPERACION QUE YO VOY A PODER REALIZAR SOBRE UNA PERSONA
 */
package dominio;



import com.mysql.cj.protocol.Resultset;
import static datos.conexion.close;
import static datos.conexion.getConnecction;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author El novio de la hermana de gon
 */
public class Persona_dao {
    
    private static final String SQL_SELECT="SELECT * FROM persona";
    private static final String SQL_INSERT="INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE persona SET nombre = ? , apellido=? , email=?, telefono=? WHERE idPersona = ?";
    private static final String SQL_DELETE="DELETE FROM persona WHERE idPersona=?";
    
    
    
    public List<Persona> seleccionar() throws SQLException{

            //inicializamos las varialbes
            Connection conn = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            Persona persona = null;
            List<Persona> personas = new ArrayList<>();

            conn = getConnecction();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();

            while(rs.next()){
                int idpersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                //instancio un nuevo objeto
                personas.add(new Persona(idpersona, nombre, apellidos, email, telefono));
            }
            close(rs);
            close(stm);
            close(conn);

            return personas;
    }
        //metodo de insertar una persona a mi sistema
    public int insertar(Persona persona){

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
                stm.setString(1,persona.getNombre());
                stm.setString(2,persona.getApellido());
                stm.setString(3,persona.getEmail());
                stm.setString(4,persona.getTelefono());

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
    
    public int actualizar(Persona persona){

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
                stm.setString(1,persona.getNombre());
                stm.setString(2,persona.getApellido());
                stm.setString(3,persona.getEmail());
                stm.setString(4,persona.getTelefono());
                stm.setInt(5, persona.getIdpersona());

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
    public int delete (Persona persona){
        Connection conn = null;
        PreparedStatement stm = null;
                 int registros=0;
                  try{  
                       conn = getConnecction();
                       stm= conn.prepareStatement(SQL_DELETE);
                       stm.setInt(1, persona.getIdpersona());
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
