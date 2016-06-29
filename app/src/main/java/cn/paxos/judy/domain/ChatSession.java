package cn.paxos.judy.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mergen on 16-6-29.
 */
public class ChatSession {

    private final int id;
    private final int targetType;
    private final int targetId;
    private final List<ChatMessage> messages = new ArrayList<>();

    public ChatSession(int id, int targetType, int targetId) {
        this.id = id;
        this.targetType = targetType;
        this.targetId = targetId;
    }

    public int getId() {
        return id;
    }

    public int getTargetId() {
        return targetId;
    }

    public int getTargetType() {
        return targetType;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }
}
