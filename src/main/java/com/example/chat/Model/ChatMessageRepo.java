package com.example.chat.Model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepo extends MongoRepository<ChatMessage,String>
{
    List<ChatMessage> findBySenderName(String senderName);

    List<ChatMessage> findByReceiverName(String receiverName);
}
