/*
 * en la clase conexion contiene todos los datos para trabajar con una conexion
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author EL NOVIO DE TU MAMA
 */
public class conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/text?useSSl=false"+ //establecemos la url
                "&useTimezone=true&serverTimezone=UTC"+
                "&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";
    
    //metodo para establecer la conexion  
    public static Connection getConnecction() throws SQLException{
    return DriverManager.getConnection(JDBC_URL, JDBC_USER,JDBC_PASSWORD);
    }
    
    //conjunto de metodos de cierre (un metodo sobrecargado)
    public static void close(ResultSet rs)throws SQLException{
        rs.close();
    }
    public static void close(Statement stm)throws SQLException{
        stm.close();
    }
    public static void close(PreparedStatement stm)throws SQLException{
        stm.close();
    }
    public static void close(Connection conn)throws SQLException{
        conn.close();
    }
    
    
    
}
