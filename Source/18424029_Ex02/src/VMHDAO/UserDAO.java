
package VMHDAO;

import HibernateConfig.HibernateUtil;
import VMHBUS.clsEncryption;
import VMHBUS.clsParameterSys;
import VMHPOJO.Userdto;
import java.io.IOException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VMHIT
 */
public class UserDAO {
    /**
     * Lấy danh sách User
     *
     */
    public static List<Userdto> GetAllUser() {
        List<Userdto> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Userdto";
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
     * Lấy danh sách User theo UserName
     */
    public static Userdto GetUserWithUserName(String _UserName) {
        Userdto obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            obj = (Userdto) session.get(Userdto.class, _UserName);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * Thêm User
     */
    @SuppressWarnings("null")
    public static boolean AddUser(Userdto _User) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (UserDAO.GetUserWithUserName(_User.getUserName()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(_User);
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
     * Cập nhật User
     */
    @SuppressWarnings("null")
    public static boolean UpdateUser(Userdto _User) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (UserDAO.GetUserWithUserName(_User.getUserName()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(_User);
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
     * Xóa User
     */
    @SuppressWarnings("null")
    public static boolean DeleteUser(String _UserName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Userdto obj = UserDAO.GetUserWithUserName(_UserName);
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

    /**
     * Thay đổi mật khẩu
     *
     */
    public static boolean ChangePasswordUser(String _UserName, String _Password) {
        boolean rs = false;
        String sPassEncrypt = clsEncryption.encrypt(_Password, _UserName);
        Userdto objUser = UserDAO.GetUserWithUserName(_UserName);
        if (objUser != null) {
            objUser.setPassword(sPassEncrypt);
            rs = UserDAO.UpdateUser(objUser);
        }
        return rs;
    }

    /**
     * Kiểm tra user đăng nhập
     *
     */
    public static boolean CheckLogin(String _UserName, String _Password) throws IOException {
        List<Userdto> lstUser = GetAllUser();
        if(lstUser.size() <=0)
        {
            return false;
        }
        for (Userdto element : lstUser) {
            String sPassDecrypt = clsEncryption.encrypt(_Password, _UserName);
            if (_UserName.equals(element.getUserName()) && sPassDecrypt.equals(element.getPassword())) {
                clsParameterSys.setIsAdmin(element.getIsAdmin());
                clsParameterSys.setUserName(element.getUserName());
                return true;
            }
        }
        return false;
    }
}
