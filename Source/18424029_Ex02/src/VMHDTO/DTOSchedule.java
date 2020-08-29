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
public class DTOSchedule {
    private DTOClass SheduleClass;

    private DTOSubject SheduleSubject;

    private String SheduleRoom;

    public DTOSchedule() {
    }

    public DTOSchedule(DTOClass Class, DTOSubject Subject, String Room) {
        this.SheduleClass = Class;
        this.SheduleSubject = Subject;
        this.SheduleRoom = Room;
    }
    
    /**
     * Get the value of SheduleClass
     *
     * @return the value of SheduleClass
     */
    public DTOClass getSheduleClass() {
        return SheduleClass;
    }

    /**
     * Set the value of SheduleClass
     *
     * @param SheduleClass new value of SheduleClass
     */
    public void setSheduleClass(DTOClass SheduleClass) {
        this.SheduleClass = SheduleClass;
    }
    
        /**
     * Get the value of SheduleSubject
     *
     * @return the value of SheduleSubject
     */
    public DTOSubject getSheduleSubject() {
        return SheduleSubject;
    }

    /**
     * Set the value of SheduleSubject
     *
     * @param SheduleSubject new value of SheduleSubject
     */
    public void setSheduleSubject(DTOSubject SheduleSubject) {
        this.SheduleSubject = SheduleSubject;
    }
    
        /**
     * Get the value of SheduleRoom
     *
     * @return the value of SheduleRoom
     */
    public String getSheduleRoom() {
        return SheduleRoom;
    }

    /**
     * Set the value of SheduleRoom
     *
     * @param SheduleRoom new value of SheduleRoom
     */
    public void setSheduleRoom(String SheduleRoom) {
        this.SheduleRoom = SheduleRoom;
    }
}
