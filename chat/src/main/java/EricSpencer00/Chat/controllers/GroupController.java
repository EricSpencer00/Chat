package EricSpencer00.Chat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import EricSpencer00.Chat.models.ChatGroup;
import EricSpencer00.Chat.models.User;
import EricSpencer00.Chat.repositories.GroupRepository;
import EricSpencer00.Chat.repositories.UserRepository;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<ChatGroup> createGroup(@RequestParam String name, @RequestParam List<Long> userIds) {
        ChatGroup chatGroup = new ChatGroup(name, null);
        
        List<User> users = userRepository.findAllById(userIds);
        chatGroup.setMembers(users);

        chatGroup = groupRepository.save(chatGroup);
        return ResponseEntity.ok(chatGroup);
    }
}