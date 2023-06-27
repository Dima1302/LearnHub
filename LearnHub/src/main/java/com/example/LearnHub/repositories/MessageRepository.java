package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Message;
import com.example.LearnHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message,String> {
    List<Message> findByReceiver(User user);

}
