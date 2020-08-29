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
public class DTOStudentClass {
    
    private long ID;
    private String Code;
    private String Name;
    private String IdentityNumber;
    private String Gender;
    private DTOClass StudentClass;

    public DTOStudentClass() {
    }

    public DTOStudentClass(long ID, String Code, String Name, String Gender, String IdentityNumber, DTOClass StudentClass) {
        this.ID = ID;
        this.Code = Code;
        this.Name = Name;
        this.IdentityNumber = IdentityNumber;
        this.Gender = Gender;
        this.StudentClass = StudentClass;
    }

    /**
     * Get the value of Gender
     *
     * @return the value of Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * Set the value of Gender
     *
     * @param Gender new value of Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * Get the value of IdentityNumber
     *
     * @return the value of IdentityNumber
     */
    public String getIdentityNumber() {
        return IdentityNumber;
    }

    /**
     * Set the value of IdentityNumber
     *
     * @param IdentityNumber new value of IdentityNumber
     */
    public void setIdentityNumber(String IdentityNumber) {
        this.IdentityNumber = IdentityNumber;
    }

    /**
     * Get the value of Name
     *
     * @return the value of Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Set the value of Name
     *
     * @param Name new value of Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public long getID() {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(long ID) {
        this.ID = ID;
    }

        /**
     * Get the value of StudentClass
     *
     * @return the value of StudentClass
     */
    public DTOClass getStudentClass() {
        return StudentClass;
    }

    /**
     * Set the value of StudentClass
     *
     * @param StudentClass new value of StudentClass
     */
    public void setStudentClass(DTOClass StudentClass) {
        this.StudentClass = StudentClass;
    }
    
        /**
     * Get the value of Code
     *
     * @return the value of Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * Set the value of Code
     *
     * @param Code new value of Code
     */
    public void setCode(String Code) {
        this.Code = Code;
    }
}
