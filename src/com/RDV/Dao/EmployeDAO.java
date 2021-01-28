package com.RDV.Dao;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RDV.beans.Employe;
import com.RDV.util.HibernateUtil;

@SuppressWarnings("rawtypes")
public class EmployeDAO extends DaoFactory{

    @SuppressWarnings("unchecked")
	public EmployeDAO(Class persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

    private String crypterMotDePasse( String motDePasse ) {
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex( motDePasse );
        return sha256hex;
    }
    
    public Employe validate(String email, String password) {
    	 System.out.println("Ana hnaaaa taniiiii 1");
        Transaction transaction = null;
        Employe employe = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            System.out.println("Ana hnaaaa taniiiii 1");
            
            password = this.crypterMotDePasse(password);
            
            System.out.println(password);
            // get an user object
            employe =  (Employe) session.createQuery("FROM Employe E WHERE E.email = :email").setParameter("email", email).uniqueResult();
            System.out.println("Ana hnaaaa taniiiii 2");
           // System.out.println(employe.getCin());
            if (employe != null && employe.getPassword().equals(password)) {
                return employe;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    

 
}
