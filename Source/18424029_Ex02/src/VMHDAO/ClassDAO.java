/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import HibernateConfig.HibernateUtil;
import VMHPOJO.*;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VMHIT
 */
public class ClassDAO {

    /**
     * Lấy danh sách Lớp
     *
     */
    public static List<Classdto> GetAllClass() {
        List<Classdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Classdto where IsActive = 1";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    /**
     * Lấy danh sách Lớp theo ID
     */
    public static Classdto GetClassWithID(Integer _ID) {
        Classdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Classdto) session.get(Classdto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Thêm Lớp
     */
    @SuppressWarnings("null")
    public static boolean AddClass(Classdto _Class) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClassDAO.GetClassWithID(_Class.getId()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_Class);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    /**
     * Cập nhật thông tin Lớp
     */
    @SuppressWarnings("null")
    public static boolean UpdateClass(Classdto _Class) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClassDAO.GetClassWithID(_Class.getId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(_Class);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    /**
     * Xóa Lớp
     */
    @SuppressWarnings("null")
    public static boolean DeleteClass(Integer _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Classdto obj = ClassDAO.GetClassWithID(_ID);
        if (obj == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
