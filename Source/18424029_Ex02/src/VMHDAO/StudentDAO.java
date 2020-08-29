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
public class StudentDAO {

    /**
     * Lấy danh sách Sinh viên
     *
     */
    public static List<Studentdto> GetAllStudent() {
        List<Studentdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Studentdto where IsActive = 1";
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
     * Lấy Sinh viên theo ID
     */
    public static Studentdto GetStudentWithID(Integer _ID) {
        Studentdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Studentdto) session.get(Studentdto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Lấy Sinh viên theo mã số
     */
    public static Studentdto GetStudentWithCode(String _Code) {
        List<Studentdto> ds = null;
        Studentdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Studentdto where isActive = 1 and studentCode = :Code";
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
     * Lấy danh sách Sinh viên theo Lớp
     */
    public static List<Studentdto> GetStudentWithClass(Integer _ID) {
        List<Studentdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Studentdto where isActive = 1 and classId = :IDClass";
            Query query = session.createQuery(hql);
            query.setInteger("IDClass", _ID);
            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    /**
     * Lấy danh sách Sinh viên theo Lớp và Môn học
     */
    public static List<Studentdto> GetStudentWithSchedule(ScheduledtoId _ID) {
        List<Studentdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = " select trn.id.studentId"
                    + " from Transcriptdto trn "
                    + " where trn.isActive = 1 and trn.id.classId = :IDClass and trn.id.subjectId = :IDSubject";

            Query query = session.createQuery(hql);
            query.setParameter("IDClass", _ID.getClassId());
            query.setParameter("IDSubject", _ID.getSubjectId());
            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    /**
     * Lấy danh sách Sinh viên của Lớp theo điều kiện
     */
    @SuppressWarnings("null")
    public static List<Studentdto> GetStudentClass(String _Code, String _Name, Integer _Gender, String _Identity, Classdto _Class) {
        List<Studentdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = " from Studentdto sts "
                    + " where sts.isActive = 1";

            if (!_Code.isEmpty()) {
                hql += " and sts.studentCode = :Code";
            }
            if (!_Name.isEmpty()) {
                hql += " and sts.studentName like :Name";
            }
            if (_Gender != 0) {
                hql += " and sts.gender = :Gender";
            }
            if (!_Identity.isEmpty()) {
                hql += " and sts.identityNumber = :Identity";
            }
            if (_Class != null) {
                hql += " and sts.classId = :IDClass";
            }

            Query query = session.createQuery(hql);

            if (!_Code.isEmpty()) {
                query.setParameter("Code", _Code);
            }
            if (!_Name.isEmpty()) {
                query.setParameter("Name", "%" + _Name + "%");
            }
            if (_Gender != 0) {
                if (_Gender == 2) {
                    query.setInteger("Gender", 0);
                } else {
                    query.setInteger("Gender", 1);
                }
            }
            if (!_Identity.isEmpty()) {
                query.setParameter("Identity", _Identity);
            }
            if (_Class != null) {
                query.setParameter("IDClass", _Class.getId());
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
     * Lấy danh sách Sinh viên của Lớp - của Môn học theo điều kiện
     */
    @SuppressWarnings("null")
    public static List<Transcriptdto> GetStudentClassSubject(String _Code, String _Name, Integer _Gender, String _Identity, Classdto _Class, Subjectdto _Subject) {
        List<Transcriptdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = " from Transcriptdto trn "
                    + " where trn.isActive = 1";

            if (!_Code.isEmpty()) {
                hql += " and trn.id.studentId.studentCode = :Code";
            }
            if (!_Name.isEmpty()) {
                hql += " and trn.id.studentId.studentName like :Name";
            }
            if (_Gender != 0) {
                hql += " and trn.id.studentId.gender = :Gender";
            }
            if (!_Identity.isEmpty()) {
                hql += " and trn.id.studentId.identityNumber = :Identity";
            }
            if (_Class != null) {
                hql += " and trn.id.classId = :ObjClass";
            }
            if (_Subject != null) {
                hql += " and trn.id.subjectId = :ObjSubject";
            }
            Query query = session.createQuery(hql);

            if (!_Code.isEmpty()) {
                query.setParameter("Code", _Code);
            }
            if (!_Name.isEmpty()) {
                query.setParameter("Name", "%" + _Name + "%");
            }
            if (_Gender != 0) {
                if (_Gender == 2) {
                    query.setInteger("Gender", 0);
                } else {
                    query.setInteger("Gender", 1);
                }
            }
            if (!_Identity.isEmpty()) {
                query.setParameter("Identity", _Identity);
            }
            if (_Class != null) {
                query.setParameter("ObjClass", _Class);
            }
            if (_Subject != null) {
                query.setParameter("ObjSubject", _Subject);
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
     * Thêm Sinh viên
     */
    @SuppressWarnings("null")
    public static boolean AddStudent(Studentdto _Student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (StudentDAO.GetStudentWithID(_Student.getId()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_Student);
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
     * Cập nhật thông tin Sinh viên
     */
    @SuppressWarnings("null")
    public static boolean UpdateStudent(Studentdto _Student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (StudentDAO.GetStudentWithID(_Student.getId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(_Student);
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
     * Xóa Sinh viên
     */
    @SuppressWarnings("null")
    public static boolean DeleteStudent(Integer _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Studentdto obj = StudentDAO.GetStudentWithID(_ID);
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
