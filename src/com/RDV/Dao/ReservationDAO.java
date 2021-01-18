package com.RDV.Dao;

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
            System.out.println("33");
            // save the reservation object
            session.save( reservation );
            System.out.println("44");
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
	
	
	
	
}
