package com.example.chat.chat;

import com.example.chat.Servicies.AddUser;
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

    public ChatController(AddUser comingadduser, SendMessage comingsendMessage)
    {
        this.AddUser=comingadduser;
        this.sendMessage=comingsendMessage;
    }


    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
    {
       return sendMessage.sendMessage(chatMessage);

        //return chatMessage;
    }


    @MessageMapping("/private-message")
    public ChatMessage recMessage(@Payload ChatMessage message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
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
