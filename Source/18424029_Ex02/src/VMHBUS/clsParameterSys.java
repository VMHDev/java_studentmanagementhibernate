/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHBUS;

/**
 *
 * @author VMHIT
 */
public class clsParameterSys {
    
    private static String UserName;

    private static Boolean IsAdmin;

    /**
     * Get the value of IsAdmin
     *
     * @return the value of IsAdmin
     */
    public static Boolean getIsAdmin() {
        return IsAdmin;
    }

    /**
     * Set the value of IsAdmin
     *
     * @param IsAdmin new value of IsAdmin
     */
    public static void setIsAdmin(Boolean IsAdmin) {
        clsParameterSys.IsAdmin = IsAdmin;
    }

    /**
     * Get the value of UserName
     *
     * @return the value of UserName
     */
    public static String getUserName() {
        return UserName;
    }

    /**
     * Set the value of UserName
     *
     * @param UserName new value of UserName
     */
    public static void setUserName(String UserName) {
        clsParameterSys.UserName = UserName;
    }

}
