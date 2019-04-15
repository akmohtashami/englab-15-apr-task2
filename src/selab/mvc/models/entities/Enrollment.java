package selab.mvc.models.entities;

import selab.mvc.models.Model;

public class Enrollment extends Model {
    private Course course;
    private Student student;
    private float grade;

    @Override
    public String getPrimaryKey() {
        return course.getPrimaryKey() + ":" + student.getPrimaryKey();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
