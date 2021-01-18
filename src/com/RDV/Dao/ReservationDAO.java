package com.RDV.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.RDV.beans.Reservation;
import com.RDV.util.HibernateUtil;

public class ReservationDAO {
	
	public void saveReservation( Reservation reservation ) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the reservation object
            session.save( reservation );
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public void updateReservation( Reservation reservation ) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // update the reservation object
            session.update( reservation );
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<Reservation> getReservations(String statut) {

        Transaction transaction = null;
        ArrayList<Reservation> listeReservations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an Reservation object
            listeReservations = (ArrayList<Reservation>) session.createQuery( "FROM reservation WHERE statut ="+statut ).getResultList();
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listeReservations;
    }
}
