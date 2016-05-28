package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Clazz {

    private final int id;
    private final String name;
    private final Teacher teacher;
    private final Map<Integer, Student> students = new HashMap<>();

    public Clazz(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
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