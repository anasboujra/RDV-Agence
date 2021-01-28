package com.RDV.Dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.RDV.beans.Employe;
import com.RDV.beans.Publication;
import com.RDV.util.HibernateUtil;

public class StatistiqueDao {
	
    @SuppressWarnings({ "unused", "unchecked" })
	public ArrayList<Integer> employe(){
    	System.out.println("Ana hnaaaa Statistique 1");
        Transaction transaction = null;
      
        
      
        int conge=0;
        int work =0;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	transaction = session.beginTransaction();
        	EmployeDAO  employeDao = new EmployeDAO(Employe.class);
			ArrayList<Employe> employes = (ArrayList<Employe>) employeDao.getAll("from Employe");
			for ( Employe employe : employes ) {
	            if(employe.getIsConge()==1) {
	            	conge++;
	            }
	        }
			
			work = employes.size() - conge;
        
        }
        ArrayList<Integer> isConge = new ArrayList<Integer>() ;
        isConge.add(work);
        isConge.add(conge);
 
    	return isConge;
    }
    
    @SuppressWarnings({ "unused"})
	public ArrayList<Integer> publication(){
    	System.out.println("Ana hnaaaa Statistique 1");
        Transaction transaction = null;
        Query query;
        
      
        BigInteger janvier;
        BigInteger fevrier;
        BigInteger mars;
        BigInteger avril;
        BigInteger mai;
        BigInteger juin;
        BigInteger juillet;
        BigInteger aout;
        BigInteger septembre;
        BigInteger october;
        BigInteger november;
        BigInteger decembre;
        
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	transaction = session.beginTransaction();
        	 janvier = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-01-01 00:00:00' AND `date`<'2021-01-31 23:59:00'").uniqueResult();
        	 fevrier = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-02-01 00:00:00' AND `date`<'2021-02-28 23:59:00'").uniqueResult();
        	 mars    = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-03-01 00:00:00' AND `date`<'2021-03-31 23:59:00'").uniqueResult();
        	 avril   = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-04-01 00:00:00' AND `date`<'2021-04-30 23:59:00'").uniqueResult();
        	 mai     = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-05-01 00:00:00' AND `date`<'2021-05-31 23:59:00'").uniqueResult(); 
        	 juin    = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-06-01 00:00:00' AND `date`<'2021-06-30 23:59:00'").uniqueResult();
        	 juillet = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-07-01 00:00:00' AND `date`<'2021-07-31 23:59:00'").uniqueResult();
        	 aout    = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-08-01 00:00:00' AND `date`<'2021-08-31 23:59:00'").uniqueResult();
        	 septembre = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-09-01 00:00:00' AND `date`<'2021-09-30 23:59:00'").uniqueResult();
        	 october = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-10-01 00:00:00' AND `date`<'2021-10-31 23:59:00'").uniqueResult();
        	 november= (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-11-01 00:00:00' AND `date`<'2021-11-30 23:59:00'").uniqueResult();
        	 decembre= (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM `publication` WHERE `date`>'2021-12-01 00:00:00' AND `date`<'2021-12-31 23:59:00'").uniqueResult();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(janvier.intValue());
        result.add(fevrier.intValue());
        result.add(mars.intValue());
        result.add(avril.intValue());
        result.add(mai.intValue());
        result.add(juin.intValue());
        result.add(juillet.intValue());
        result.add(aout.intValue());
        result.add(septembre.intValue());
        result.add(october.intValue());
        result.add(november.intValue());
        result.add(decembre.intValue());
        
 
    	return result;
    }

}
