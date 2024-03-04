package it.itsvil.loginhibernate.controller;
import it.itsvil.loginhibernate.hibernate.HibernateUtil;
import it.itsvil.loginhibernate.model.UtenteBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class UtenteCRUD {

    public static void insertUtente(UtenteBean utente) {
        Session session = null;
        Transaction tx = null;
        UtenteBean result = null;
        try {
            result = selectUtenteByUsername(utente);
            if(result==null) {
                session = HibernateUtil.openSession();
                tx = session.beginTransaction();
                session.save(utente);
                tx.commit();;
            }else {
                System.out.println("Username già esistente!");
            }
        }catch(Exception e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();;
        }finally {
            if(session!=null) {
                session.close();
            }
        }

    }

   public static UtenteBean selectUtente(UtenteBean utente) {
        UtenteBean result = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            result = (UtenteBean) session.createQuery("FROM UtenteBean WHERE username=:username AND password=:pw").setParameter("username",utente.getUsername()).setParameter("pw",utente.getPassword()).uniqueResult();
        }catch(Exception e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }        }
        return result;
   }

    public static UtenteBean selectUtenteByUsername(UtenteBean utente) {
        UtenteBean result = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            result = (UtenteBean) session.createQuery("FROM UtenteBean WHERE username=:username").setParameter("username",utente.getUsername()).uniqueResult();
        }catch(Exception e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }        }
        return result;
    }
}
