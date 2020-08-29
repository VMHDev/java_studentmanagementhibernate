/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDAO;

import HibernateConfig.HibernateUtil;
import VMHPOJO.*;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VMHIT
 */
public class CheckExaminationScheduleDAO {

    /**
     * Lấy danh sách Lịch phúc khảo
     *
     */
    public static List<Checkexaminationscheduledto> GetAllCheckExaminationSchedule() {
        List<Checkexaminationscheduledto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Checkexaminationscheduledto where IsActive = 1";
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
     * Lấy danh sách Lịch phúc khảo theo ID
     */
    public static Checkexaminationscheduledto GetCheckexaminationscheduleWithID(CheckexaminationscheduledtoId _ID) {
        Checkexaminationscheduledto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Checkexaminationscheduledto) session.get(Checkexaminationscheduledto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Lấy danh sách Lịch phúc khảo theo lớp và môn học
     */
    public static Checkexaminationscheduledto GetCheckexaminationscheduleWithClassSubject(Classdto _Class, Subjectdto _Subject) {
        List<Checkexaminationscheduledto> ds = null;
        Checkexaminationscheduledto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Checkexaminationscheduledto where IsActive = 1 and formDate <= :Date and toDate >= :Date";
            Query query = session.createQuery(hql);
            query.setParameter("Date", new Date());
            ds = query.list();
            if (ds.size() > 0) {
                for (Checkexaminationscheduledto item : ds) {
                    if (item.getId().getClassId().getId() == _Class.getId() && item.getId().getSubjectId().getId() == _Subject.getId()) {
                        obj = item;
                        return obj;
                    }
                }
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }
    
    /**
     * Thêm Lịch phúc khảo
     */
    @SuppressWarnings("null")
    public static boolean AddCheckexaminationschedule(Checkexaminationscheduledto _Checkexaminationschedule) {
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
     * Cập nhật Lịch phúc khảo
     */
    @SuppressWarnings("null")
    public static boolean UpdateCheckexaminationschedule(Checkexaminationscheduledto _Checkexaminationschedule) {
        Boolean rs = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CheckExaminationScheduleDAO.GetCheckexaminationscheduleWithID(_Checkexaminationschedule.getId()) == null) {
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
     * Xóa Lịch phúc khảo
     */
    @SuppressWarnings("null")
    public static boolean DeleteCheckexaminationschedule(CheckexaminationscheduledtoId _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Checkexaminationscheduledto obj = CheckExaminationScheduleDAO.GetCheckexaminationscheduleWithID(_ID);
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
