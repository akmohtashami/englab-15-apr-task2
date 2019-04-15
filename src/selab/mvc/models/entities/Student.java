package selab.mvc.models.entities;

import selab.mvc.models.Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Student extends Model {
    private String name;
    private String studentNo;

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    private ArrayList<Enrollment> getEnrollments() {
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        for (Enrollment enrollment: this.getDataContext().getEnrollments().getAll())
            if (enrollment.getStudent() == this)
                enrollments.add(enrollment);
        return enrollments;
    }

    public float getAverage() {
        ArrayList<Enrollment> enrollments = this.getEnrollments();
        float sum = 0;
        for (Enrollment enrollment: enrollments)
            sum += enrollment.getGrade();
        if (enrollments.size() == 0)
            return 0;
        return (float)sum / enrollments.size();
    }

    public String getCourses() {
        ArrayList<Enrollment> enrollments = this.getEnrollments();
        ArrayList<String> courseNames = new ArrayList<>();
        for (Enrollment enrollment: enrollments)
            courseNames.add(enrollment.getCourse().getTitle());
        return String.join(",", courseNames);
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }

    @Override
    public void remove() {
        for (Enrollment enrollment: this.getEnrollments())
            enrollment.remove();
        super.remove();

    }
}
