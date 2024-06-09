package com.example.chat.chat;

import lombok.*;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage
{


    private LocalDateTime date;
    private String senderName;
    private String receiverName;
    private String message;

    private Status status;
}




