package EricSpencer00.Chat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EricSpencer00.Chat.repositories.GroupRepository;
import EricSpencer00.Chat.repositories.UserRepository;
import EricSpencer00.Chat.models.ChatGroup;
import EricSpencer00.Chat.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupController(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ChatGroup createGroup(@RequestParam String name) {
        return groupRepository.save(new ChatGroup(null, name, null));
    }

    @PostMapping("/{groupId}/addUser/{userId}") 
    public ChatGroup addUserToGroup(@PathVariable Long groupId, @PathVariable long userId) {
        ChatGroup group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        group.getMembers().add(user);
        return groupRepository.save(group);
    }
}
