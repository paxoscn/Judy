package cn.paxos.judy.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class User {

    private final Integer id;
    private final String name;
    private final Map<Integer, Student> students = new HashMap<>();

    private User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static boolean loggedIn() {
        return false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }


}
