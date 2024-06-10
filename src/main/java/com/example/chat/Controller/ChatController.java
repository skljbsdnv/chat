package com.example.chat.Controller;

import com.example.chat.Model.ChatMessage;
import com.example.chat.Servicies.AddUser;
import com.example.chat.Servicies.MongoServices;
import com.example.chat.Servicies.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    private final AddUser AddUser;
    private final SendMessage sendMessage;
    private final MongoServices mongo;

    public ChatController(AddUser comingadduser, SendMessage comingsendMessage, MongoServices mongo)
    {
        this.AddUser=comingadduser;
        this.sendMessage=comingsendMessage;
        this.mongo=mongo;
    }


    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
    {
        mongo.saveChatMessage(chatMessage);
        return sendMessage.publicMessage(chatMessage);

        //return chatMessage;
    }


    @MessageMapping("/private-message")
    public ChatMessage recMessage(@Payload ChatMessage message)
    {
        sendMessage.PrivateMessage(message);
        mongo.saveChatMessage(message);
        return message;
    }





    @MessageMapping("/chat.addUser")
    @SendTo("/chatroom/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage , SimpMessageHeaderAccessor headerAccessor)
    {
       return AddUser.adduser(chatMessage,headerAccessor );
        //return chatMessage;
    }




}
