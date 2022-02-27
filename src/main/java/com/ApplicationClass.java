package com;


import com.messenger.model.AbstractMessage;
import com.messenger.model.Conversation;
import com.messenger.model.ConversationContext;
import com.messenger.model.TextMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ApplicationClass {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationClass.class, args);

        List<UUID> senders = new ArrayList<>();
        senders.add(UUID.randomUUID());
        senders.add(UUID.randomUUID());
        senders.add(UUID.randomUUID());

        List<List<AbstractMessage>> msgListArray = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            List<AbstractMessage> msgList= new ArrayList<>();
            for (int i = 0; i < 10; i++) {

                msgList.add(new TextMessage("Conversation" + j + "MSG" + i, UUID.randomUUID(), new Date())); //generate UUID
                System.out.println(msgList.get(i).toString());
            }
            msgListArray.add(msgList);
        }

        List<Conversation> conversationList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Conversation tmp = new Conversation(UUID.randomUUID(), "CNV name" + i, UUID.randomUUID());
            tmp.setMembersUUIDList(senders);
            tmp.setConversationMessages(msgListArray.get(i));
            conversationList.add(tmp);
            System.out.println(conversationList.get(i).toString());
        }



        ConversationContext.getInstance().setConversations(conversationList);
        System.out.println(ConversationContext.getInstance().toString());
    }

}