/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Adriana
 */
public class MateriaDAO {
    //Atributo privado para conectarse con la base de datos

    private SessionFactory sessionFactory;

    /**
     * Inicializa la sesión para conectarse con la base de datos
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda una materia en la base de datos
     *
     * @param materia
     */
    public void guardar(Materia materia) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.persist(materia);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Termino de guardar");
    }

    /**
     * Método que elimina una materia de la base de datos
     *
     * @param materia
     */
    public void eliminar(Materia materia) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.delete(materia);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /**
     * Método que regresa una materia, cuyo id es el que se pasa como parámetro
     *
     * @param idMateria
     * @return
     */
    public Materia getMateria(long idMateria) {
        Materia mat = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            mat = (Materia)session.get(Materia.class, idMateria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return mat;
    }

    /**
     * Método que regresa todas las materias
     *
     * @return
     */
    public List all() {
        System.out.println("entro al metodo all");
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List materias = new ArrayList();
        try {
            String hql = " from Materia";
            Query query = session.createQuery(hql);
            query.uniqueResult();
            materias = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("termino");
        return materias;
    }
}
