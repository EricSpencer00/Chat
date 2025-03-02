package EricSpencer00.Chat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import EricSpencer00.Chat.models.ChatGroup;
import EricSpencer00.Chat.models.Message;
import EricSpencer00.Chat.models.User;
import EricSpencer00.Chat.repositories.GroupRepository;
import EricSpencer00.Chat.repositories.MessageRepository;
import EricSpencer00.Chat.repositories.UserRepository;
import EricSpencer00.Chat.services.ChatService;

@SpringBootTest
public class ChatApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;

    private User alice;
    private User bob;
    private ChatGroup group;

    @BeforeEach
    void setup() {
        // Create Users
        alice = userRepository.save(new User("Alice"));
        bob = userRepository.save(new User("Bob"));

        // Create Group
        group = groupRepository.save(new ChatGroup("Study Group", List.of(alice, bob)));

        // Add a message
        messageRepository.save(new Message(alice, group, "Hello everyone!", LocalDateTime.now()));
    }

    // @Test
    // void testCreateUser() {
    //     User user = userRepository.save(new User("Charlie"));
    //     assertThat(user.getId()).isNotNull();
    //     assertThat(user.getUsername()).isEqualTo("Charlie");
    // }

    // @Test
    // void testCreateChatGroup() {
    //     ChatGroup newGroup = groupRepository.save(new ChatGroup("Gaming Group", List.of(alice)));
    //     assertThat(newGroup.getId()).isNotNull();
    //     assertThat(newGroup.getName()).isEqualTo("Gaming Group");
    // }

    // @Test
    // void testSendMessage() {
    //     Message message = chatService.sendMessage(alice.getId(), group.getId(), "Hey Bob, how's it going?");
    //     assertThat(message.getId()).isNotNull();
    //     assertThat(message.getContent()).isEqualTo("Hey Bob, how's it going?");
    //     assertThat(message.getSender()).isEqualTo(alice);
    // }

    // @Test
    // void testRetrieveMessages() {
    //     List<Message> messages = chatService.getMessages(group.getId());
    //     assertThat(messages).isNotEmpty();
    //     assertThat(messages.get(0).getContent()).isEqualTo("Hello everyone!");
    // }
}
