/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario {
   private int idusario;
   private String contraseña;
   private String nombre;
   
   //getter and setter

    public int getIdusario() {
        return idusario;
    }

    public void setIdusario(int idusario) {
        this.idusario = idusario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    //contructores

    public Usuario(int idusario, String contraseña, String nombre) {
        this.idusario = idusario;
        this.contraseña = contraseña;
        this.nombre = nombre;
    }

    public Usuario(String contraseña, String nombre) {
        this.contraseña = contraseña;
        this.nombre = nombre;
    }

    public Usuario(int idusario) {
        this.idusario = idusario;
    }
    
    //hascode and equals

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idusario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idusario != other.idusario) {
            return false;
        }
        return true;
    }
//toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{idusario=").append(idusario);
        sb.append(", contrase\u00f1a=").append(contraseña);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
    
   
   
   
   
}
