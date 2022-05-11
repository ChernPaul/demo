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
public class ConversationsController {


    private static class Views{
        public static final String ADD_CONVERSATION = "addConversation";
        public static final String CONVERSATIONS = "viewConversations";
        public static final String ADD_CONVERSATION_RESULT = "addConversationResult";
        public static final String DELETE_CONVERSATION = "deleteConversation";
        public static final String UPDATE_CONVERSATION = "updateConversation";
        public static final String UPDATE_CONVERSATION_RESULT = "updateConversationResult";
    }

    private static class ModelAttributes{
        public static final String CONVERSATION = "conversation";
        public static final String CONVERSATIONS_LIST = "conversations_list";
        public static final String CONVERSATION_CREATOR_UUID = "conversation_creator_uuid";

    }
    private static class PathVariables{
        public static final String CONVERSATION_ID = "conversation_id";
    }

    private static class Endpoints{
        public static final String ADD_CONVERSATION = "/add";
        public static final String DELETE_CONVERSATION = "/{conversation_id}/delete";
        public static final String UPDATE_CONVERSATION = "/{conversation_id}/update";
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

        //model.addAttribute(ModelAttributes.CONVERSATION, conversation);

        // RANDOM DATA
        conversation.setConversationUUID(UUID.randomUUID());
        conversation.setCreatorUUID(UUID.randomUUID());
        conversation.setConversationMessages(new ArrayList<>());
        conversation.getConversationMessages().add(new TextMessage("Conversation created"));
        // RANDOM DATA

        ConversationContext.getInstance().getConversations().add(conversation);
        return Views.ADD_CONVERSATION_RESULT;
    }

    @GetMapping(value = Endpoints.DELETE_CONVERSATION)
    public String messageDeleteForm(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversation_id, Model model) {
        ConversationContext.getInstance().removeConversationByID(conversation_id);
        return Views.DELETE_CONVERSATION;
    }

    @GetMapping(value = Endpoints.UPDATE_CONVERSATION)
    public String conversationUpdateForm(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversation_id,
                                         Model model) {
        model.addAttribute(ModelAttributes.CONVERSATION,  new Conversation());
        model.addAttribute(ModelAttributes.CONVERSATION_CREATOR_UUID, conversation_id.toString());
        return Views.UPDATE_CONVERSATION;
    }
    @PostMapping(value = Endpoints.UPDATE_CONVERSATION)
    public String updateConversationAndCheck(@ModelAttribute(name="conversation") Conversation conversation,
                                             Model model,
                                             @PathVariable(PathVariables.CONVERSATION_ID) UUID conversation_id){

        Conversation updatedConversation = ConversationContext.getInstance().getConversationByUUID(conversation_id);
        updatedConversation.setCreatorUUID(conversation.getCreatorUUID());
        updatedConversation.setConversationName(conversation.getConversationName());
        return Views.UPDATE_CONVERSATION_RESULT;
    }

}
