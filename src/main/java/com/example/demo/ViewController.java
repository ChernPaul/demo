package com.example.demo;


import com.messenger.AbstractMessage;
import com.messenger.Conversations;
import com.messenger.TextMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO: в отдельный пакет (controllers)
@Controller
public class ViewController {

    @GetMapping("/conversationsView" /* TODO: Магическую строку выделить в константы */)
    public String viewConversations(Model model){
        model.addAttribute("conversationsList" /* TODO: Магическую строку выделить в константы */, Conversations.getInstance().getConversations());
        return "conversationsView" /* TODO: Магическую строку выделить в константы */;
    }


    @GetMapping("/conversationView/{UUID}" /* TODO: Магическую строку выделить в константы */)
    /* TODO: Раз начал с префиксов (на методах) "view", то делай так везде */
    /* TODO: Что такое "WithVariableName ?? */
    public String getEmployeesByIdWithVariableName(@PathVariable("UUID" /* TODO: Магическую строку выделить в константы */) UUID id, Model model) {

        List<AbstractMessage> abstractList = Conversations.getInstance().getConversationByUUID(id).getConversationMessages();
        ArrayList<TextMessage> messagesList = new ArrayList<>();

        /* TODO: Посмотреть, не лучше ли заменить на foreach */
        for(int i = 0; i < abstractList.size(); i++)
        {
            messagesList.add((TextMessage)abstractList.get(i));
        }

        model.addAttribute("messagesList" /* TODO: Магическую строку выделить в константы */,messagesList);
        return "conversationView" /* TODO: Магическую строку выделить в константы */;
    }

}