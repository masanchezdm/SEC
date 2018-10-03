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
@Table(name="materia")

/**
 *
 * @author Adriana
 */
public class Materia implements Serializable{
    
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    //id del usuario
    private long idMateria;
    
    //El nombre de la materia
    @Column(name = "nombre")
    private String nombre;

    public long getIdMateria() {
        return idMateria;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }    
    
}
