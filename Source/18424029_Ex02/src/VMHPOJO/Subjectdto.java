package VMHPOJO;
// Generated Aug 17, 2019 4:28:30 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Subjectdto generated by hbm2java
 */
public class Subjectdto implements java.io.Serializable {

    private int id;
    private String subjectCode;
    private String subjectName;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

    public Subjectdto() {
    }

    public Subjectdto(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.createdDate = new Date();
        this.updatedDate = new Date();
        this.isActive = true;
    }

    public Subjectdto(int id, String subjectCode, String subjectName, Date createdDate, Date updatedDate, Boolean isActive) {
        this.id = id;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActive = isActive;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // The "toString" method will be used by the JComboBox to generate the label for the item
    @Override
    public String toString() {
        return getSubjectName();
    }
}