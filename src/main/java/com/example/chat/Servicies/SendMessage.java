package com.example.chat.Servicies;

import com.example.chat.Model.ChatMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SendMessage
{


    private SimpMessagingTemplate simpMessagingTemplate;

    public SendMessage(SimpMessagingTemplate simpMessagingTemplate)
    {
        this.simpMessagingTemplate=simpMessagingTemplate;
    }




    public ChatMessage publicMessage(@Payload ChatMessage chatMessage)
    {
        chatMessage.setDate(LocalDateTime.now());
        return chatMessage;
    }



    public ChatMessage PrivateMessage(@Payload ChatMessage chatMessage)
    {

        simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiverName(),"/private",chatMessage);

        return chatMessage;
    }



}
