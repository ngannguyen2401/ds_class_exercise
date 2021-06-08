package sample;

public class student {
    private int student_id;
    private String name;
    private float grade;

    public student() {
    }

    public student(int student_id, String name, float grade) {
        this.student_id = student_id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return student_id;
    }

    public void setId(int student_id) {
        this.student_id= student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {

        return (this.student_id == ((student)obj).student_id);

    }

    @Override
    public String toString() {
        return "ID: " + student_id +
                " - Name: " + name +
                " - grade: " + grade;
    }


    public int hashCode(){
        return this.student_id;
    }
}
