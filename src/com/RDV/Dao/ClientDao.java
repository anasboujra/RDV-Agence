package com.RDV.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.RDV.beans.Client;
import com.RDV.util.HibernateUtil;


public class ClientDao {
	
	public void deleteClient(int id) {

        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Client client = session.get( Client.class, id );
            if ( client != null ) {
                session.delete( client );
                System.out.println( "client is deleted" );
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
	public Client getClient(int id) {

		Transaction transaction = null;
        Client client = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            client = session.get( Client.class, id );
            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return client;
	}
	@SuppressWarnings( "unchecked" )
    public ArrayList<Client> getAllClient() {

        Transaction transaction = null;
        ArrayList<Client> listOfClient = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfClient = (ArrayList<Client>) session.createQuery( "from Client" ).getResultList();

            // commit transaction
            transaction.commit();
        } catch ( Exception e ) {
            if ( transaction != null ) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfClient;
    }
}
