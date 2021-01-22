package com.RDV.Dao;
 

/**
 * CRUD database operations
 *  
 *
 */

@SuppressWarnings("rawtypes")
public class PublicationDao extends DaoFactory {
 
	    @SuppressWarnings("unchecked")
		public PublicationDao( Class persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

		/*public void savePublication(Publication publication) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            System.out.println("Kant hna 1");
	            // save the publication object
	            session.save(publication);
	            System.out.println("Kant hna 2");
	            // commit transaction
	            transaction.commit();
	            System.out.println("Kant hna 3");
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }*/

	    /**
	     * Update User
	     * @param user
	     */
	    /*public void updatePublication(Publication publication) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()
	        		) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            //persistenceManager.findObjectById(publication .getId());

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
	    }*/

	    /**
	     * Delete User
	     * @param id
	     */
	   /* public void deletePublication(int id) {

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
	    }*/

	    /**
	     * Get User By ID
	     * @param id
	     * @return
	     */
	    /*public Publication getPublication(int id) {

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
	    }*/

	    /**
	     * Get all Users
	     * @return
	     */
	    /*
	    @SuppressWarnings("unchecked")
	    public List <Publication > getAllPublications() {

	        Transaction transaction = null;
	        ArrayList < Publication > publications = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            System.out.println("Ana hona");
	            publications = (ArrayList<Publication>) session.createQuery("from Publication").getResultList();
	            System.out.println("Ana hona2");
	            
	            // commit transaction
	            transaction.commit();
	            session.close();
	        } catch (Exception e) {
	        	 transaction.rollback();
	            if (transaction != null) {
	                
	            }
	            e.printStackTrace();
	        }
 
	        return publications;
	    }*/
	}


