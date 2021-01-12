package com.RDV.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.RDV.beans.Publication;
import com.RDV.util.HibernateUtil;

/**
 * CRUD database operations
 *  
 *
 */

public class PublicationDao {
	
	
 

	    /**
	     * Save User
	     * @param user
	     */
	    public void savePublication(Publication publication) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the publication object
	            session.save(publication);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Update User
	     * @param user
	     */
	    public void updatePublication(Publication publication) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(publication);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Delete User
	     * @param id
	     */
	    public void deletePublication(int id) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a user object
	            Publication publication = session.get(Publication.class, id);
	            if (publication != null) {
	                session.delete(publication);
	                System.out.println("Publication is deleted");
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Get User By ID
	     * @param id
	     * @return
	     */
	    public Publication getPublication(int id) {

	        Transaction transaction = null;
	        Publication publication = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get a publication object
	            publication = session.get(Publication.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return publication;
	    }

	    /**
	     * Get all Users
	     * @return
	     */
	    	
	    @SuppressWarnings("unchecked")
	    public List <Publication > getAllPublications() {

	        Transaction transaction = null;
	        List < Publication > publications = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            publications = session.createQuery("from publication").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
 
	        return publications;
	    }
	}


