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
    private final SoftReference<Institution> institution;
    private final Map<Integer, SoftReference<Teacher>> teachers = new HashMap<>();
    private final Map<Integer, SoftReference<Student>> students = new HashMap<>();

    private Clazz(int id, String name, Institution institution) {
        this.id = id;
        this.name = name;
        this.institution = new SoftReference<>(institution);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Institution getInstitution() {
        return institution.get();
    }

}