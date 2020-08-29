/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import HibernateConfig.HibernateUtil;
import VMHPOJO.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VMHIT
 */
public class SubjectDAO {

    /**
     * Lấy danh sách Môn học
     *
     */
    public static List<Subjectdto> GetAllSubject() {
        List<Subjectdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Subjectdto where IsActive = 1";
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
     * Lấy Môn học theo ID
     */
    public static Subjectdto GetSubjectWithID(Integer _ID) {
        Subjectdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Subjectdto) session.get(Subjectdto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Lấy Môn học theo ID
     */
    public static Subjectdto GetSubjectWithCode(String _Code) {
        List<Subjectdto> ds = null;
        Subjectdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Subjectdto where IsActive = 1 and subjectCode = :Code";
            Query query = session.createQuery(hql);
            query.setParameter("Code", _Code);
            ds = query.list();
            if (ds.size() > 0) {
                obj = ds.get(0);
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Thêm Môn học
     */
    @SuppressWarnings("null")
    public static boolean AddSubject(Subjectdto _Subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.GetSubjectWithID(_Subject.getId()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_Subject);
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
     * Cập nhật thông tin Môn học
     */
    @SuppressWarnings("null")
    public static boolean UpdateSubject(Subjectdto _Subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.GetSubjectWithID(_Subject.getId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(_Subject);
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
     * Xóa Môn học
     */
    @SuppressWarnings("null")
    public static boolean DeleteSubject(Integer _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Subjectdto obj = SubjectDAO.GetSubjectWithID(_ID);
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
