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
public class CheckExaminationDAO {

    /**
     * Lấy danh sách Phúc khảo
     *
     */
    public static List<Checkexaminationdto> GetAllCheckExamination() {
        List<Checkexaminationdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Checkexaminationdto where IsActive = 1";
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
     * Lấy danh sách Phúc khảo theo sinh viên
     *
     */
    public static List<Checkexaminationdto> GetCheckExaminationWithStudent(Studentdto _Student) {
        List<Checkexaminationdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Checkexaminationdto cex where cex.isActive = 1"
                    + " and cex.id.studentId = :ObjStudent";
            Query query = session.createQuery(hql);
            query.setParameter("ObjStudent", _Student);

            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    /**
     * Lấy danh sách Phúc khảo theo sinh viên
     *
     */
    public static List<Checkexaminationdto> GetCheckExamination(Classdto _Class, Subjectdto _Subject, char _Status) {
        List<Checkexaminationdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Checkexaminationdto cex where cex.isActive = 1";
            if (_Class != null) {
                hql += " and cex.id.classId = :ObjClass";
            }
            if (_Subject != null) {
                hql += " and cex.id.subjectId = :ObjSubject";
            }
            if (_Status != ' ') {
                hql += " and cex.statusCheck = :cStatus";
            }

            Query query = session.createQuery(hql);

            if (_Class != null) {
                query.setParameter("ObjClass", _Class);
            }
            if (_Subject != null) {
                query.setParameter("ObjSubject", _Subject);
            }
            if (_Status != ' ') {
                query.setCharacter("cStatus", _Status);
            }

            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
        /**
     * Lấy danh sách Phúc khảo theo sinh viên chưa cập nhật
     *
     */
    public static List<Checkexaminationdto> GetCheckExaminationNotComplete(Classdto _Class, Subjectdto _Subject, char _Status) {
        List<Checkexaminationdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Checkexaminationdto cex where cex.isActive = 1";
            if (_Class != null) {
                hql += " and cex.id.classId = :ObjClass";
            }
            if (_Subject != null) {
                hql += " and cex.id.subjectId = :ObjSubject";
            }
            if (_Status != ' ') {
                hql += " and cex.statusCheck != :cStatus";
            }

            Query query = session.createQuery(hql);

            if (_Class != null) {
                query.setParameter("ObjClass", _Class);
            }
            if (_Subject != null) {
                query.setParameter("ObjSubject", _Subject);
            }
            if (_Status != ' ') {
                query.setCharacter("cStatus", _Status);
            }

            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    /**
     * Lấy danh sách Phúc khảo theo ID
     */
    public static Checkexaminationdto GetCheckexaminationWithID(CheckexaminationdtoId _ID) {
        Checkexaminationdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Checkexaminationdto) session.get(Checkexaminationdto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Thêm Phúc khảo
     */
    @SuppressWarnings("null")
    public static boolean AddCheckexamination(Checkexaminationdto _Checkexaminationschedule) {
        Boolean rs = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_Checkexaminationschedule);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            rs = false;
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * Cập nhật Phúc khảo
     */
    @SuppressWarnings("null")
    public static boolean UpdateCheckexamination(Checkexaminationdto _Checkexaminationschedule) {
        Boolean rs = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CheckExaminationDAO.GetCheckexaminationWithID(_Checkexaminationschedule.getId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(_Checkexaminationschedule);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            rs = false;
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * Xóa Phúc khảo
     */
    @SuppressWarnings("null")
    public static boolean DeleteCheckexamination(CheckexaminationdtoId _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Checkexaminationdto obj = CheckExaminationDAO.GetCheckexaminationWithID(_ID);
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
