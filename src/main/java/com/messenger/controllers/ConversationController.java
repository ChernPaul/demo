package com.messenger.controllers;
import com.messenger.model.Conversation;
import com.messenger.model.ConversationContext;
import com.messenger.model.TextMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;


@Controller
@RequestMapping("/conversations")
public class ConversationController {


    private static class Views{
        public static final String ADD_CONVERSATION = "addConversation";
        public static final String CONVERSATIONS = "viewConversations";
        public static final String ADD_CONVERSATION_RESULT = "addConversationResult";
    }

    private static class ModelAttributes{
        public static final String CONVERSATION = "conversation";
        public static final String CONVERSATIONS_LIST = "conversations_list";

    }

    private static class Endpoints{
        public static final String ADD_CONVERSATION = "/add";
    }

    @GetMapping
    public String viewConversations(Model model){
        model.addAttribute(ModelAttributes.CONVERSATIONS_LIST, ConversationContext.getInstance().getConversations());
        return Views.CONVERSATIONS;
    }


    @GetMapping(value = Endpoints.ADD_CONVERSATION)
    public String conversationAddForm(Model model) {
        model.addAttribute(ModelAttributes.CONVERSATION,  new Conversation());
        return Views.ADD_CONVERSATION;
    }

    @PostMapping(value = Endpoints.ADD_CONVERSATION)
    public String addConversationAndCheck(@ModelAttribute(name="conversation") Conversation conversation,
                                          Model model){


        model.addAttribute(ModelAttributes.CONVERSATION, conversation);

        // RANDOM DATA
        conversation.setConversationUUID(UUID.randomUUID());
        conversation.setCreatorUUID(UUID.randomUUID());
        conversation.setConversationMessages(new ArrayList<>());
        conversation.getConversationMessages().add(new TextMessage("Conversation created"));
        // RANDOM DATA

        ConversationContext.getInstance().getConversations().add(conversation);
        return Views.ADD_CONVERSATION_RESULT;
    }


}
