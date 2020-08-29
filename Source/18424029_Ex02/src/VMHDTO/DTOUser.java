/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VMHDTO;

/**
 *
 * @author VMHIT
 */
public class DTOUser {
    
    private String UserName;

    private String Password;

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Get the value of UserName
     *
     * @return the value of UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * Set the value of UserName
     *
     * @param UserName new value of UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

}
