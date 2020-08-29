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
public class DTOSubject {

    private long ID;

    private String Code;

    private String Name;

    public DTOSubject() {
    }

    public DTOSubject(long ID, String Code) {
        this.ID = ID;
        this.Code = Code;
    }

    public DTOSubject(long ID, String Code, String Name) {
        this.ID = ID;
        this.Code = Code;
        this.Name = Name;
    }

    public DTOSubject(DTOSubject objSubject) {
        this.ID = objSubject.getID();
        this.Code = objSubject.getCode();
        this.Name = objSubject.getName();
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

    // The "toString" method will be used by the JComboBox to generate the label for the item
    @Override
    public String toString() {
        return getName();
    }
}
