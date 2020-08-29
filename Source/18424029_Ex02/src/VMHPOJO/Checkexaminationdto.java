package VMHPOJO;
// Generated Aug 24, 2019 10:14:06 AM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Checkexaminationdto generated by hbm2java
 */
public class Checkexaminationdto implements java.io.Serializable {

    private CheckexaminationdtoId id;
    private String scoresType;
    private float scoresWish;
    private float scoresCheck;
    private String reason;
    private char statusCheck;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

    public Checkexaminationdto() {
    }

    public Checkexaminationdto(CheckexaminationdtoId id, String scoresType, float scoresWish, float scoresCheck, String reason, char statusCheck) {
        this.id = id;
        this.scoresType = scoresType;
        this.scoresWish = scoresWish;
        this.scoresCheck = scoresCheck;
        this.reason = reason;
        this.statusCheck = statusCheck;
        this.createdDate = new Date();
        this.updatedDate = new Date();
        this.isActive = true;
    }

    public Checkexaminationdto(CheckexaminationdtoId id, String scoresType, float scoresWish, float scoresCheck, String reason, char statusCheck, Date createdDate, Date updatedDate, Boolean isActive) {
        this.id = id;
        this.scoresType = scoresType;
        this.scoresWish = scoresWish;
        this.scoresCheck = scoresCheck;
        this.reason = reason;
        this.statusCheck = statusCheck;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActive = isActive;
    }

    public CheckexaminationdtoId getId() {
        return this.id;
    }

    public void setId(CheckexaminationdtoId id) {
        this.id = id;
    }

    public String getScoresType() {
        return this.scoresType;
    }

    public void setScoresType(String scoresType) {
        this.scoresType = scoresType;
    }

    public float getScoresWish() {
        return this.scoresWish;
    }

    public void setScoresWish(float scoresWish) {
        this.scoresWish = scoresWish;
    }

    public float getScoresCheck() {
        return this.scoresCheck;
    }

    public void setScoresCheck(float scoresCheck) {
        this.scoresCheck = scoresCheck;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public char getStatusCheck() {
        return this.statusCheck;
    }

    public void setStatusCheck(char statusCheck) {
        this.statusCheck = statusCheck;
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

}