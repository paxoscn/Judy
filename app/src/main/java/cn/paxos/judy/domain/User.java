package cn.paxos.judy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        Iterator<Clazz> classIter = Institution.instance.getClasses().values().iterator();
        Clazz firstClass = classIter.next();
        Clazz secondClass = classIter.next();
        Clazz thirdClass = classIter.next();
        currentUser.getStudents().values().iterator().next().getClasses().put(firstClass.getId(), firstClass);
        currentUser.getStudents().values().iterator().next().getClasses().put(thirdClass.getId(), thirdClass);
        return true;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public Clazz selectDefaultClass() {
        // TODO
        return students.values().iterator().next().getClasses().values().iterator().next();
    }

    public Iterable<Clazz> listOtherClasses(Clazz viewedClass) {
        List<Clazz> others = new ArrayList<>();
        for (Student student : students.values()) {
            for (Clazz clazz : student.getClasses().values()) {
                if (viewedClass.getId() != clazz.getId()) {
                    others.add(clazz);
                }
            }
        }
        return others;
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
