package cn.paxos.judy.domain;

/**
 * Created by mergen on 16-6-29.
 */
public class ChatMessage {

    private final int id;
    private final int sessionId;
    private final Class<?> senderType;
    private final Class<?> receiverType;
    private final int senderId;
    private final int receiverId;
    private final long time;
    private final String message;

    public ChatMessage(int id, int sessionId, Class<?> senderType, Class<?> receiverType, int senderId, int receiverId, long time, String message) {
        this.id = id;
        this.sessionId = sessionId;
        this.senderType = senderType;
        this.receiverType = receiverType;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.time = time;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public Class<?> getReceiverType() {
        return receiverType;
    }

    public int getSenderId() {
        return senderId;
    }

    public Class<?> getSenderType() {
        return senderType;
    }

    public int getSessionId() {
        return sessionId;
    }

    public long getTime() {
        return time;
    }
}
