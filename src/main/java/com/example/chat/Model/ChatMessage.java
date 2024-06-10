package com.example.chat.Model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "chatMessages")
public class ChatMessage
{

    @Id
    private String id;
    private String senderName;
    private String message;
    private String receiverName;
    private LocalDateTime date;
    private Status status;
}




