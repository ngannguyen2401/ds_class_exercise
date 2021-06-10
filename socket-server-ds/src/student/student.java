package student;

import java.io.Serializable;

public class student implements Serializable{
    private String studentName;
    private String studentID;
    private String studentGender;
    private String year;

    public student(String studentName, String studentID, String studentGender, String year) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentGender = studentGender;
        this.year = year;

    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }
    public String getStudentGender() {
        return studentGender;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getYear() {
        return year;
    }
}
