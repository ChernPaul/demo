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


@Controller
public class ViewController {

    @GetMapping("/conversationsView")
    public String viewConversations(Model model){
        model.addAttribute("conversationsList", Conversations.getInstance().getConversations());
        return "conversationsView";
    }


    @GetMapping("/conversationView/{UUID}")
    public String getEmployeesByIdWithVariableName(@PathVariable("UUID") UUID id, Model model) {

        List<AbstractMessage> abstractList = Conversations.getInstance().getConversationByUUID(id).getConversationMessages();
        ArrayList<TextMessage> messagesList = new ArrayList<>();
        for(int i = 0; i < abstractList.size(); i++)
        {
            messagesList.add((TextMessage)abstractList.get(i));
        }


        model.addAttribute("messagesList",messagesList);
        return "conversationView";
    }

}