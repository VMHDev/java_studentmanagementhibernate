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
public class TranscriptDAO {

    /**
     * Lấy danh sách Bảng điểm
     */
    public static List<Transcriptdto> GetAllTranscript() {
        List<Transcriptdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Transcriptdto where isActive = 1";
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
     * Lấy danh sách Bảng điểm theo ID
     */
    public static Transcriptdto GetTranscriptWithID(TranscriptdtoId _ID) {
        Transcriptdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Transcriptdto) session.get(Transcriptdto.class, _ID);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Lấy danh sách Bảng điểm theo điều kiện
     */
    public static List<Transcriptdto> GetTranscript(Classdto _Class, Subjectdto _Subject, Studentdto _Student) {
        List<Transcriptdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Transcriptdto trn where trn.isActive = 1";
            if (_Class != null) {
                hql += " and trn.id.classId = :ObjClass";
            }
            if (_Subject != null) {
                hql += " and trn.id.subjectId = :ObjSubject";
            }
            if (_Student != null) {
                hql += " and trn.id.studentId = :ObjStudent";
            }
            
            Query query = session.createQuery(hql);

            if (_Class != null) {
                query.setParameter("ObjClass", _Class);
            }
            if (_Subject != null) {
                query.setParameter("ObjSubject", _Subject);
            }
            if (_Student != null) {
                query.setParameter("ObjStudent", _Student);
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
     * Thêm Bảng điểm
     */
    @SuppressWarnings("null")
    public static Integer AddTranscript(Transcriptdto _Transcript) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (TranscriptDAO.GetTranscriptWithID(_Transcript.getId()) != null) {
            return -1;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_Transcript);
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
     * Khỏi tạo Bảng điểm khi thêm một TKB
     */
    public static boolean InitTranscript(ScheduledtoId _ScheduleId) {
        try {
            List<Studentdto> lstStudent = StudentDAO.GetStudentWithClass(_ScheduleId.getClassId().getId());
            for (Studentdto item : lstStudent) {
                TranscriptdtoId objId = new TranscriptdtoId(item, _ScheduleId);
                Transcriptdto objTrans = new Transcriptdto(objId);
                TranscriptDAO.AddTranscript(objTrans);
            }
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
        return true;
    }

    /**
     * Cập nhật thông tin điểm của sinh viên Nếu tồn tại sinh viên: Cập nhật
     * điểm Nếu chưa tồn tai sinh viên: Thêm mới Return: -1: Thêm mới | 0: Thất
     * bại | 1: Cập nhật
     */
    @SuppressWarnings("null")
    public static Integer UpdateScoresTranscript(Transcriptdto _Transcript) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (TranscriptDAO.GetTranscriptWithID(_Transcript.getId()) == null) {
            AddTranscript(_Transcript);
            return -1;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String sQuery = "update Transcriptdto trn set"
                    + " trn.scoresMid = :Mid,"
                    + " trn.scoresEnd = :End,"
                    + " trn.scoresOther = :Other,"
                    + " trn.scoresSum = :Sum,"
                    + " trn.updatedDate = :Date,"
                    + " trn.isActive = :Active"
                    + " where trn.id = :ID";
            Query query2 = session.createQuery(sQuery);
            query2.setParameter("Mid", _Transcript.getScoresMid());
            query2.setParameter("End", _Transcript.getScoresEnd());
            query2.setParameter("Other", _Transcript.getScoresOther());
            query2.setParameter("Sum", _Transcript.getScoresSum());
            query2.setParameter("Date", _Transcript.getUpdatedDate());
            query2.setParameter("Active", _Transcript.getIsActive());
            query2.setParameter("ID", _Transcript.getId());
            query2.executeUpdate();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Nhập dữ liệu sinh viên mã số" + _Transcript.getId().getStudentId().getStudentCode() + "thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            session.close();
        }
        return 1;
    }

    /**
     * Xóa Bảng điểm
     */
    @SuppressWarnings("null")
    public static boolean DeleteTranscript(TranscriptdtoId _ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transcriptdto obj = TranscriptDAO.GetTranscriptWithID(_ID);
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
