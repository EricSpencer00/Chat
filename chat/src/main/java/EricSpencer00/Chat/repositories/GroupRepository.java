package EricSpencer00.Chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import EricSpencer00.Chat.models.ChatGroup;

public interface GroupRepository extends JpaRepository<ChatGroup, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO chat_groups (name) VALUES (:name)", nativeQuery = true)
    void createGroup(@Param("name") String name);

    @Modifying
    @Transactional
    @Query ("UPDATE ChatGroup g SET g.members = :user WHERE g.id = :groupId")
    void addUserToGroup(Long groupId, Long userId);

    @Modifying
    @Transactional
    @Query ("UPDATE ChatGroup g SET g.members = :user WHERE g.id = :groupId")
    void removeUserFromGroup(Long groupId, Long userId);

    ChatGroup findByName(String name);
}
