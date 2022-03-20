package com;


import com.messenger.model.*;
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

        List<User> senders = new ArrayList<>();
        senders.add(new User(UUID.randomUUID(), "Name 1" , "Description 1" ));
        senders.add(new User(UUID.randomUUID(), "Name 2" , "Description 2" ));
        senders.add(new User(UUID.randomUUID(), "Name 3" , "Description 3" ));

        List<List<AbstractMessage>> msgListArray = new ArrayList<>();
        List<User> usersList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            List<AbstractMessage> msgList= new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                User user = new User(UUID.randomUUID(), "Name" + i, "Description" + i);
                usersList.add(user);
                msgList.add(new TextMessage("Conversation" + j + "MSG" + i, user.getUserId(), new Date())); //generate UUID
                System.out.println(msgList.get(i).toString());
            }
            msgListArray.add(msgList);
        }

        List<Conversation> conversationList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Conversation tmp = new Conversation(UUID.randomUUID(), "CNV name" + i, usersList.get(i));
            tmp.setMembersList(senders);
            tmp.setConversationMessages(msgListArray.get(i));
            conversationList.add(tmp);
            System.out.println(conversationList.get(i).toString());
        }


        UserContext.getInstance().setUsers(usersList);
        ConversationContext.getInstance().setConversations(conversationList);
        System.out.println(ConversationContext.getInstance().toString());
    }

}