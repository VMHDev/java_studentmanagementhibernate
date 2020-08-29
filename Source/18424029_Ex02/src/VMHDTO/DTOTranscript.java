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
public class DTOTranscript {
    
    private DTOStudentSubject Student;
    
    private float ScoresMid;

    private float ScoresEnd;

    private float ScoresOther;

    private float ScoresSum;

    public DTOTranscript() {
    }

    public DTOTranscript(DTOStudentSubject Student, float ScoresMid, float ScoresEnd, float ScoresOther, float ScoresSum) {
        this.Student = Student;
        this.ScoresMid = ScoresMid;
        this.ScoresEnd = ScoresEnd;
        this.ScoresOther = ScoresOther;
        this.ScoresSum = ScoresSum;
    }
    
    /**
     * Get the value of ScoresSum
     *
     * @return the value of ScoresSum
     */
    public float getScoresSum() {
        return ScoresSum;
    }

    /**
     * Set the value of ScoresSum
     *
     * @param ScoresSum new value of ScoresSum
     */
    public void setScoresSum(float ScoresSum) {
        this.ScoresSum = ScoresSum;
    }

    /**
     * Get the value of ScoresOther
     *
     * @return the value of ScoresOther
     */
    public float getScoresOther() {
        return ScoresOther;
    }

    /**
     * Set the value of ScoresOther
     *
     * @param ScoresOther new value of ScoresOther
     */
    public void setScoresOther(float ScoresOther) {
        this.ScoresOther = ScoresOther;
    }

    /**
     * Get the value of ScoresEnd
     *
     * @return the value of ScoresEnd
     */
    public float getScoresEnd() {
        return ScoresEnd;
    }

    /**
     * Set the value of ScoresEnd
     *
     * @param ScoresEnd new value of ScoresEnd
     */
    public void setScoresEnd(float ScoresEnd) {
        this.ScoresEnd = ScoresEnd;
    }

    /**
     * Get the value of ScoresMid
     *
     * @return the value of ScoresMid
     */
    public float getScoresMid() {
        return ScoresMid;
    }

    /**
     * Set the value of ScoresMid
     *
     * @param ScoresMid new value of ScoresMid
     */
    public void setScoresMid(float ScoresMid) {
        this.ScoresMid = ScoresMid;
    }


    /**
     * Get the value of Student
     *
     * @return the value of Student
     */
    public DTOStudentSubject getStudent() {
        return Student;
    }

    /**
     * Set the value of Student
     *
     * @param Student new value of Student
     */
    public void setStudent(DTOStudentSubject Student) {
        this.Student = Student;
    }

}
