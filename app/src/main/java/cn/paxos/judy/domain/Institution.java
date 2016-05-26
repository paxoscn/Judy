package cn.paxos.judy.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Institution {

    private final Map<Integer, Teacher> teachers = new HashMap<>();
    private final Map<Integer, Clazz> classes = new HashMap<>();

    public Map<Integer, Teacher> getTeachers() {
        return teachers;
    }

    public Map<Integer, Clazz> getClasses() {
        return classes;
    }

}
