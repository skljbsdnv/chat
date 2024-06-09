package com.example.chat.Servicies;

import com.example.chat.chat.ChatMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Time
{
    public ChatMessage localTime(@Payload ChatMessage chatMessage)
    {
        chatMessage.setDate(LocalDateTime.now()); // Set the current date and time
        return chatMessage;
    }

}
