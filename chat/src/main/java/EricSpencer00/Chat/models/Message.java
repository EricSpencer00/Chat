package EricSpencer00.Chat.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private ChatGroup chatGroup;

    private String content;

    private LocalDateTime timestamp;

    public Message(User sender, ChatGroup chatGroup, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.chatGroup = chatGroup;
        this.content = content;
        this.timestamp = timestamp;
    }
}
