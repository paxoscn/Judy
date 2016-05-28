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

    private static User currentUser = null;

    private User(Integer id, String name) {
        this.id = id;
        this.name = name;
        // FIXME
        students.put(1, new Student(1, "小明", this));
    }

    public static boolean loggedIn() {
        return currentUser != null;
    }

    public static boolean login(String mTel, String mPassword) {
        // TODO
        currentUser = new User(1, "张女士");
        Clazz firstClass = Institution.instance.getClasses().values().iterator().next();
        currentUser.getStudents().values().iterator().next().getClasses().put(firstClass.getId(), firstClass);
        return true;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public Clazz selectDefaultClass() {
        // TODO
        return students.values().iterator().next().getClasses().values().iterator().next();
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
