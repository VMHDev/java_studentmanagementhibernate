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
public class ScheduleDAO {

    /**
     * Lấy danh sách Thời khóa biểu
     *
     */
    public static List<Scheduledto> GetAllSchedule() {
        List<Scheduledto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Scheduledto where isActive = 1";
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
     * Lấy danh sách Thời khóa biểu theo ID
     */
    public static Scheduledto GetScheduleWithID(ScheduledtoId _ID) {
        Scheduledto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Scheduledto) session.get(Scheduledto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Lấy danh sách Thời khóa biểu theo điều kiện
     *
     */
    public static List<Scheduledto> GetSchedule(Classdto _Class, Subjectdto _Subject, String _Room) {
        List<Scheduledto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Scheduledto sch where sch.isActive = 1";
            if (_Class != null) {
                hql += " and sch.id.classId = :ObjClass";
            }
            if (_Subject != null) {
                hql += " and sch.id.subjectId = :ObjSubject";
            }
            if (!_Room.isEmpty()) {
                hql += " and sch.classRoom = :Room";
            }         

            Query query = session.createQuery(hql);

            if (_Class != null) {
                query.setParameter("ObjClass", _Class);
            }
            if (_Subject != null) {
                query.setParameter("ObjSubject", _Subject);
            }
            if (!_Room.isEmpty()) {
                query.setParameter("Room", _Room);
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
     * Thêm Thời khóa biểu
     */
    @SuppressWarnings("null")
    public static Integer AddSchedule(Scheduledto _Schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ScheduleDAO.GetScheduleWithID(_Schedule.getId()) != null) {
            return -1;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_Schedule);
            TranscriptDAO.InitTranscript(_Schedule.getId());
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            return 0;
        } finally {
            session.close();
        }
        return 1;
    }

    /**
     * Cập nhật thông tin Thời khóa biểu
     */
    @SuppressWarnings("null")
    public static boolean UpdateSchedule(Scheduledto _Schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ScheduleDAO.GetScheduleWithID(_Schedule.getId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(_Schedule);
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
     * Xóa Thời khóa biểu
     */
    @SuppressWarnings("null")
    public static boolean DeleteSchedule(ScheduledtoId _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Scheduledto obj = ScheduleDAO.GetScheduleWithID(_ID);
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
