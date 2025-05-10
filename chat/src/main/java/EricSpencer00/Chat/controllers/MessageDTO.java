package EricSpencer00.Chat.controllers;

import java.time.LocalDateTime;
import java.util.UUID;

import EricSpencer00.Chat.models.Message;
import EricSpencer00.Chat.models.User;

public class MessageDTO {
    private Long id;
    private String content;
    private LocalDateTime timestamp;
    private User sender;

    public MessageDTO(Long id, String content, LocalDateTime timestamp, User sender) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.sender = sender;
    }

    public Long getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public User getSender() {
        return sender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setSenderUsername(User senderUsername) {
        this.sender = senderUsername;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", senderUsername=" + sender +
                '}';
    }
    
    public static MessageDTO fromMessage(Message message) {
        return new MessageDTO(message.getId(), message.getContent(), message.getTimestamp(), message.getSender());
    }
}
