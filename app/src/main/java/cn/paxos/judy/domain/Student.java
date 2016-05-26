package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;

/**
 * Created by mergen on 16-5-24.
 */
public class Student {

    private final int id;
    private final String name;
    private final SoftReference<User> user;

    private Student(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = new SoftReference<>(user);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user.get();
    }

}