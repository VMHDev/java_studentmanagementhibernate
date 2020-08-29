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
public class DTOClass {

    private long ID;
    private String ClassName;

    public DTOClass() {
    }

    public DTOClass(long ID, String ClassName) {
        this.ID = ID;
        this.ClassName = ClassName;
    }
    
    public DTOClass(DTOClass objClass) {
        this.ID = objClass.getID();
        this.ClassName = objClass.getClassName();
    }
    
    /**
     * Get the value of ClassName
     *
     * @return the value of ClassName
     */
    public String getClassName() {
        return ClassName;
    }

    /**
     * Set the value of ClassName
     *
     * @param ClassName new value of ClassName
     */
    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
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
        return getClassName();
    }
}
