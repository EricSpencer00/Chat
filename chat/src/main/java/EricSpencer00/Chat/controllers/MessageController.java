package EricSpencer00.Chat.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import EricSpencer00.Chat.models.Message;
import EricSpencer00.Chat.services.ChatService;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final ChatService chatService;

    public MessageController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public Message sendMessage(@RequestParam Long senderId, @RequestParam Long groupId, @RequestParam String content) {
        return chatService.sendMessage(senderId, groupId, content);
    }

    @GetMapping("/group/{groupId}")
    public List<Message> getMessages(@PathVariable Long groupId) {
        return chatService.getMessages(groupId);
    }

    @GetMapping("/group/{groupId}/messages")
    public List<MessageDTO> getMessagesDTO(@PathVariable Long groupId) {
        return chatService.getMessages(groupId).stream()
                .map(MessageDTO::fromMessage)
                .collect(Collectors.toList());
    }
}