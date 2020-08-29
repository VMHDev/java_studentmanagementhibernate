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
public class KeyValue {

    private String ID;

    private String Value;

    public KeyValue() {
    }

    public KeyValue(String _ID, String _Name) {
        this.ID = _ID;
        this.Value = _Name;
    }

    /**
     * Get the value of Value
     *
     * @return the value of Value
     */
    public String getValue() {
        return Value;
    }

    /**
     * Set the value of Value
     *
     * @param Value new value of Value
     */
    public void setValue(String Value) {
        this.Value = Value;
    }

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
