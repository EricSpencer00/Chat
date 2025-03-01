package EricSpencer00.Chat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EricSpencer00.Chat.models.ChatGroup;
import EricSpencer00.Chat.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByGroupChat(ChatGroup chatGroup);
}
