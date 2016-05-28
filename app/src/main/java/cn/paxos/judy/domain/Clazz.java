package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Clazz {

    private final int id;
    private final String name;
    private final Teacher teacher;
    private final Map<Integer, Student> students = new HashMap<>();
    private final List<ClassInstance> instances = new ArrayList<>();

    public Clazz(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        // FIXME
        ClassInstance instance = new ClassInstance(1, 20160501);
        instance.setTeacherReview(new TeacherReview());
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(2, 20160508);
        instance.setTeacherReview(new TeacherReview());
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(3, 20160515);
        instance.setTeacherReview(new TeacherReview());
        instance.setHomework(new Homework());
        instance.setExam(new Exam());
        instances.add(instance);
        instance = new ClassInstance(4, 20160522);
        instance.setTeacherReview(new TeacherReview());
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(5, 20160529);
        instances.add(instance);
        instance = new ClassInstance(6, 20160605);
        instances.add(instance);
    }

    public List<ClassInstance> listInstances() {
        List<ClassInstance> listedInstances = new ArrayList<>(instances);
        Collections.reverse(listedInstances);
        return listedInstances;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }
}