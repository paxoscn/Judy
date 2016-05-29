package cn.paxos.judy.domain;

/**
 * Created by mergen on 16-5-29.
 */
public class ClassInstance {

    private final int id;
    private final long time;

    private TeacherReview teacherReview = null;
    private Homework homework = null;
    private Exam exam = null;

    public ClassInstance(int id, long time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public TeacherReview getTeacherReview() {
        return teacherReview;
    }

    public void setTeacherReview(TeacherReview teacherReview) {
        this.teacherReview = teacherReview;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
