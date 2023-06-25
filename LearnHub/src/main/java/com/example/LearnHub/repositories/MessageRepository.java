package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Message;
import com.example.LearnHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,String> {
    List<Message> findByReceiver(User user);

}
