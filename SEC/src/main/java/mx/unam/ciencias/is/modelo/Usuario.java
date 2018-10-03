/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name="usuario")

/**
 *
 * @author jonh
 */
public class Usuario implements Serializable{
    
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    //id del usuario
    private long idPersona;
    
    //El nombre del usuario
    @Column(name = "Nombre")
    private String nombre;
    
    //El correo del usuario
    @Column(name = "Correo")
    private String correo;
    
    //La contrasenia del usuario
    @Column(name = "Contrasena")
    private String contrasenia;
    
    //El apellido paterno del usuario
    @Column(name = "App")
    private String app;
    
    //El apellido materno del usuario
    @Column(name = "Apm")
    private String apm;
    
    //El apellido materno del usuario
    @Column(name = "Telefono")
    private String tel;
    
    //El rol del usuario
    @Column(name = "Rol")
    private Integer rol;

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Usuario(String nombre, String correo, String contrasenia, String app, String apm, String tel) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.app = app;
        this.apm = apm;
        this.tel = tel;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario() {
    }

    public Usuario(long idPersona, String nombre, String correo, String contrasenia) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Usuario(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    
    
}
