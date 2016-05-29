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
        Teacher firstTeacher = new Teacher(1, "Ada", this);
        teachers.put(1, firstTeacher);
        Teacher secondTeacher = new Teacher(2, "Leon", this);
        teachers.put(2, secondTeacher);
        Clazz firstClass = new Clazz(1, "周三 Basic One", firstTeacher);
        classes.put(1, firstClass);
        Clazz secondClass = new Clazz(2, "周六 Basic One", firstTeacher);
        classes.put(2, secondClass);
        Clazz thirdClass = new Clazz(3, "周日 Basic One", secondTeacher);
        classes.put(3, thirdClass);
        firstTeacher.addClass(firstClass);
    }

    public Map<Integer, Teacher> getTeachers() {
        return teachers;
    }

    public Map<Integer, Clazz> getClasses() {
        return classes;
    }

}
