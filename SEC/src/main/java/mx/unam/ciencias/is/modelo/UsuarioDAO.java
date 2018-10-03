/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jonh
 */
public class UsuarioDAO {
     //Atributo privado para conectarse con la base de datos
    private SessionFactory sessionFactory;
    
    /**
     * Inicializa la sesión para conectarse con la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Método que guarda un usuario en la base de datos
     * @param usuario
     */
    public void guardar(Usuario usuario) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(usuario);
           
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        System.out.println("Termino de guardar");
    }
    
    
    /**
     * Método que elimina a un usuario de la base de datos
     * @param usuario 
     */
    public void eliminar(Usuario usuario) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(usuario);
           
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    
    }
    /**
     * Método que regresa a un usuario, cuyo id es el que se pasa como 
     * parámetro
     * @param idUsuario
     * @return 
     */
    public Usuario getPersona(long idUsuario) {
        Usuario persona = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           persona = (Usuario)session.get(Usuario.class, idUsuario);
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return persona;
    }
   
    /**
     * Método que regresa un usuario cuyo correo se pasa como parámetro
     * @param correo
     * @return 
     */
    public Usuario getPersona(String correo) {
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = " from Usuario where correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            result = (Usuario)query.uniqueResult();
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }

    public Usuario getPersona2(String correo, String contrasena) {
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = " from Usuario where correo = :correo and contrasena = :contrasena";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contrasena", contrasena);
            result = (Usuario)query.uniqueResult();
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    
    public Usuario updateNombre(Long id,String nombre) {        
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "update Usuario set nombre = :nombre"+
    				" where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);
            query.executeUpdate();
            result = getPersona(id);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    public Usuario updateApp(Long id,String nombre) {        
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "update Usuario set app = :nombre"+
    				" where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);
            query.executeUpdate();
            result = getPersona(id);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    public Usuario updateApm(Long id,String nombre) {        
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "update Usuario set apm = :nombre"+
    				" where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);
            query.executeUpdate();
            result = getPersona(id);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    public Usuario updateCorreo(Long id,String nombre) {        
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "update Usuario set correo = :nombre"+
    				" where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);
            query.executeUpdate();
            result = getPersona(id);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    public Usuario updateContrasena(Long id,String nombre) {        
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "update Usuario set contrasena = :nombre"+
    				" where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);
            query.executeUpdate();
            result = getPersona(id);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    public Usuario updateTelefono(Long id,String nombre) {        
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "update Usuario set telefono = :nombre"+
    				" where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);
            query.executeUpdate();
            result = getPersona(id);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
}
