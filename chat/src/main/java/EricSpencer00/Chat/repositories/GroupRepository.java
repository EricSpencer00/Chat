package EricSpencer00.Chat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EricSpencer00.Chat.models.ChatGroup;

public interface GroupRepository extends JpaRepository<ChatGroup, Long> {
    void createGroup(String name, List<Long> userIds);

    // @Modifying
    // @Transactional
    // @Query ("UPDATE ChatGroup g SET g.members = :user WHERE g.id = :groupId")
    // void addUserToGroup(Long groupId, Long userId);

    void addUserToGroup(Long groupId, Long userId);
}
