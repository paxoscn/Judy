package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;

/**
 * Created by mergen on 16-5-24.
 */
public class Teacher {

    private final int id;
    private final String name;
    private final SoftReference<Institution> institution;

    private Teacher(int id, String name, Institution institution) {
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