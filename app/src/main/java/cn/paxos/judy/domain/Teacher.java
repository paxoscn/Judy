package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Teacher {

    private final int id;
    private final String name;
    private final Institution institution;
    private final Map<Integer, Clazz> classes = new HashMap<>();

    public Teacher(int id, String name, Institution institution) {
        this.id = id;
        this.name = name;
        this.institution = institution;
    }

    public void addClass(Clazz clazz) {
        classes.put(clazz.getId(), clazz);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Institution getInstitution() {
        return institution;
    }

}