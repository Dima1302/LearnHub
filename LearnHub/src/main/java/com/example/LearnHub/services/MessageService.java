package com.example.LearnHub.services;

import com.example.LearnHub.dto.MessageDTO;
import com.example.LearnHub.dto.UserDTO;
import com.example.LearnHub.models.Message;
import com.example.LearnHub.models.User;
import com.example.LearnHub.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;

    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public MessageDTO createMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setContent(messageDTO.getContent());

        Message savedMessage = messageRepository.save(message);
        return convertToDTO(savedMessage);
    }

    public List<MessageDTO> getAllMessages() {
        List<Message> messages = messageRepository.findAll();

        return messages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, receiver, content);
        messageRepository.save(message);
    }






    public List<MessageDTO> getReceivedMessages(UserDTO userDTO) {
        User user = convertToUser(userDTO);

        List<Message> receivedMessages = messageRepository.findByReceiver(user);
        return receivedMessages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MessageDTO convertToDTO(Message message) {
        return new MessageDTO(message.getContent());
    }

    private User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        // Set other user properties if needed

        return user;
    }
}
