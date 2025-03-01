package EricSpencer00.Chat.services;

import org.springframework.stereotype.Service;

import EricSpencer00.Chat.models.ChatGroup;
import EricSpencer00.Chat.models.Message;
import EricSpencer00.Chat.models.User;
import EricSpencer00.Chat.repositories.GroupRepository;
import EricSpencer00.Chat.repositories.MessageRepository;
import EricSpencer00.Chat.repositories.UserRepository;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class ChatService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public ChatService(MessageRepository messageRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public Message sendMessage(Long senderId, Long groupId, String content) {
        User sender = userRepository.findById(senderId).orElseThrow();
        ChatGroup chatGroup = groupRepository.findById(groupId).orElseThrow();

        Message message = new Message(null, sender, chatGroup, content, LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long groupId) {
        ChatGroup chatGroup = groupRepository.findById(groupId).orElseThrow();
        return messageRepository.findByChatGroup(chatGroup);
    }
}
