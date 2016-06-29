package cn.paxos.judy.domain;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mergen on 16-5-24.
 */
public class Clazz {

    private final int id;
    private final String name;
    private final Teacher teacher;
    private final Map<Integer, Student> students = new HashMap<>();
    private final List<ClassInstance> instances = new ArrayList<>();

    public Clazz(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        // FIXME
        ClassInstance instance = new ClassInstance(1, 201603081300L + id);
        instance.setChatSession(new ChatSession(1, 1, 1));
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(2, 201603151300L + id);
        instance.setChatSession(new ChatSession(2, 1, 2));
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(3, 201603231300L + id);
        instance.setChatSession(new ChatSession(3, 1, 3));
        instance.setHomework(new Homework());
        instance.setExam(new Exam());
        instances.add(instance);
        instance = new ClassInstance(4, 201605011300L + id);
        instance.setChatSession(new ChatSession(4, 1, 4));
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(5, 201605081300L + id);
        instance.setChatSession(new ChatSession(5, 1, 5));
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(6, 201605151300L + id);
        instance.setChatSession(new ChatSession(6, 1, 6));
        instance.setHomework(new Homework());
        instance.setExam(new Exam());
        instances.add(instance);
        instance = new ClassInstance(7, 201605221300L + id);
        instance.setChatSession(new ChatSession(7, 1, 7));
        instance.getChatSession().getMessages().add(new ChatMessage(1, 7, Teacher.class, User.class, 1, 1, 201605221300L + id, "Well done !"));
        instance.getChatSession().getMessages().add(new ChatMessage(1, 7, User.class, Teacher.class, 1, 1, 201605221500L + id, "Thx !"));
        instance.setHomework(new Homework());
        instances.add(instance);
        instance = new ClassInstance(8, 201605291300L + id);
        instances.add(instance);
        instance = new ClassInstance(9, 201606051300L + id);
        instances.add(instance);
    }

    public List<ClassInstance> listInstances() {
        List<ClassInstance> listedInstances = new ArrayList<>(instances);
        Collections.reverse(listedInstances);
        return listedInstances;
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