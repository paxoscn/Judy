package cn.paxos.judy.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Institution {

    public static final Institution instance = new Institution();

    private final Map<Integer, Teacher> teachers = new HashMap<>();
    private final Map<Integer, Clazz> classes = new HashMap<>();

    public Institution() {
        // FIXME
        Teacher firstTeacher = new Teacher(1, "Ada老师", this);
        teachers.put(1, firstTeacher);
        Clazz firstClass = new Clazz(1, "周六 Basic One", firstTeacher);
        classes.put(1, firstClass);
        firstTeacher.addClass(firstClass);
    }

    public Map<Integer, Teacher> getTeachers() {
        return teachers;
    }

    public Map<Integer, Clazz> getClasses() {
        return classes;
    }

}
