package EricSpencer00.Chat.models;

import jakarta.persistence.*;
import lombok.*; 

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ManyToMany(mappedBy = "members")
    private List<ChatGroup> chatGroups;

    public User(String username) {
        this.username = username;
    }
}
