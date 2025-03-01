package EricSpencer00.Chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import EricSpencer00.Chat.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
