package com.example.LearnHub.controllers;

import com.example.LearnHub.dto.MessageDTO;
import com.example.LearnHub.dto.UserDTO;
import com.example.LearnHub.models.User;
import com.example.LearnHub.services.MessageService;
import com.example.LearnHub.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final UserService userService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        MessageDTO createdMessage = messageService.createMessage(messageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        String senderUsername = messageDTO.getSender().getUsername();
        String receiverUsername = messageDTO.getReceiver().getUsername();
        String content = messageDTO.getContent();

        User sender = userService.getUserByUsername(senderUsername);
        User receiver = userService.getUserByUsername(receiverUsername);
        messageService.sendMessage(sender, receiver, content);

        return ResponseEntity.ok("Message sent successfully");
    }


    @PostMapping("/received")
    public ResponseEntity<List<MessageDTO>> getReceivedMessages(@RequestBody UserDTO userDTO) {
        List<MessageDTO> receivedMessages = messageService.getReceivedMessages(userDTO);
        return ResponseEntity.ok(receivedMessages);
    }
}
