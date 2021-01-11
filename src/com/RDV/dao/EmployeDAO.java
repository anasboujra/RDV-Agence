package com.RDV.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.RDV.beans.Employe;
import com.RDV.util.HibernateUtil;

public class EmployeDAO {

    public void saveEmploye( Employe employe ) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save( employe );
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateEmploye( Employe employe ) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update( employe );
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEmploye( int id ) {

        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Employe employe = session.get( Employe.class, id );
            if ( employe != null ) {
                session.delete( employe );
                System.out.println( "employe is deleted" );
            }

            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employe getEmploye( int id ) {

        Transaction transaction = null;
        Employe employe = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            employe = session.get( Employe.class, id );
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employe;
    }

    @SuppressWarnings( "unchecked" )
    public ArrayList<Employe> getAllEmploye() {

        Transaction transaction = null;
        ArrayList<Employe> listOfEmploye = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfEmploye = (ArrayList<Employe>) session.createQuery( "from Employe" ).getResultList();

            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfEmploye;
    }
}
