package EricSpencer00.Chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import EricSpencer00.Chat.models.ChatGroup;

public interface GroupRepository extends JpaRepository<ChatGroup, Long> {
}
