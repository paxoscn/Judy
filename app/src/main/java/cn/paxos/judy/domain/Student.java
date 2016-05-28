package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Student {

    private final int id;
    private final String name;
    private final User user;
    private final Map<Integer, Clazz> classes = new HashMap<>();

    public Student(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public Map<Integer, Clazz> getClasses() {
        return classes;
    }
}