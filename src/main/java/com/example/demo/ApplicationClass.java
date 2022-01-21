package com.example.demo;

/* TODO: Оптимизация импортов осуществляется с помощью Ctrl + Alt + O (это не ноль!) */
import java.util.*;

import com.messenger.AbstractMessage;
import com.messenger.Conversation;
import com.messenger.Conversations;
import com.messenger.TextMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationClass {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationClass.class, args);
        // Здесь можно делать любую инициализацию
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {

            List<UUID> senders = new ArrayList<UUID>();
            senders.add(UUID.randomUUID());
            senders.add(UUID.randomUUID());
            senders.add(UUID.randomUUID());
            List<AbstractMessage> msgList= new ArrayList<AbstractMessage>();

            for (int i = 0; i < 10; i++) {

                msgList.add(new TextMessage("MSG" + i, UUID.randomUUID(), new Date())); //generate UUID
                System.out.println(msgList.get(i).toString());
            }

            List<Conversation> cnvsList = new ArrayList<Conversation>();
            for (int i = 0; i < 10; i++) {

                cnvsList.add(new Conversation(UUID.randomUUID(), "CNV name" + i, senders, UUID.randomUUID(), msgList));
                System.out.println(cnvsList.get(i).toString());
            }

            Conversations.getInstance().setConversations(cnvsList);
            System.out.println(Conversations.getInstance().toString());

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }



}