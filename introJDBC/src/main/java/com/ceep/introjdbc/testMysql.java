/*
 *conexion de testeo con base de datos mysql
 */
package com.ceep.introjdbc;

import dominio.Persona;
import dominio.Persona_dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author EL NOVIO DE TU MAMA
 */
public class testMysql {
    
    public static void main(String[] args) {
        Persona p1 = new Persona("NIKOLAS","BELTREKE","NIBELTRE@GMAIL.COM","675325415");
        Persona p2 = new Persona(3,"Luis","Morado","luismora@GMAIL.COM","674632545");
        Persona p3 = new Persona(4);
        
      Persona_dao personaDao = new Persona_dao();
      
      //VISUALIZAR LA BASE DE DATOS
        try {
            List<Persona> personas = personaDao.seleccionar();
            personas.forEach(Persona -> {
                System.out.println("persona = "+ Persona);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //insertar persona a la base de datos
        //personaDao.insertar(p1);
        //personaDao.actualizar(p2);
        personaDao.delete(p3);
       
        
        
        
    
    
    }
}
