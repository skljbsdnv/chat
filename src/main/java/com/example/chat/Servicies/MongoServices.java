package com.example.chat.Servicies;


import com.example.chat.Model.ChatMessageRepo;
import com.example.chat.Model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoServices
{
    @Autowired
    private ChatMessageRepo chatMessageRepository;



    public ChatMessage saveChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }


}
