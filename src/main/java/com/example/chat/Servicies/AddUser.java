package com.example.chat.Servicies;

import com.example.chat.Model.ChatMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;

@Component
public class AddUser
{
    public ChatMessage adduser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor)
    {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderName());
        return chatMessage;
    }
}
