/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;

/**
 *
 * @author adrisan
 */
public class UsuarioI {
    private String nombre;
    private String app;
    private String apm;
    private String correo;
    private String telefono;
    private String contrasena;
    private Integer is_profesor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getIs_profesor() {
        return is_profesor;
    }

    public void setIs_profesor(Integer is_profesor) {
        this.is_profesor = is_profesor;
    }

    public UsuarioI(String correo, String contrasena, Integer is_profesor) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = correo;
        this.is_profesor = is_profesor;
    }

    public UsuarioI(String nombre, String app, String apm, String correo, String telefono, String contrasena, Integer is_profesor) {
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.is_profesor = is_profesor;
    }
    public void update(String nombre, String app, String apm, String correo, String telefono, String contrasena) {
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public UsuarioI() {
    }
}
