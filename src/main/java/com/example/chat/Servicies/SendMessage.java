package com.example.chat.Servicies;

import com.example.chat.chat.ChatMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SendMessage
{

    private final Time time;

    public SendMessage(Time time)
    {
        this.time = time;
    }


    public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
    {
        time.localTime(chatMessage);
        return chatMessage;
    }
}
