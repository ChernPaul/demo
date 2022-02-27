package com.messenger.controllers;

import com.messenger.model.AbstractMessage;
import com.messenger.model.Conversation;
import com.messenger.model.ConversationContext;
import com.messenger.model.TextMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;




@Controller
@RequestMapping("/conversations/{conversation_id}/messages")
public class MessagesController {

    private static class PathVariables{
        public static final String CONVERSATION_ID = "conversation_id";
    }
    private static class Views{
        public static final String ADD_MESSAGE = "addMessage";
        public static final String CONVERSATION = "viewConversation";
        public static final String ADD_MESSAGE_RESULT = "addMessageResult";

    }

    private static class ModelAttributes{
        public static final String MESSAGE = "message";
        public static final String MESSAGES_LIST = "messages_list";
        public static final String CONVERSATION_ID = "conversation_id";
    }

    private static class Endpoints{
        public static final String ADD_MESSAGE = "/add";
    }

    @GetMapping
    // /conversations/{conversation_id}/messages (все сообщения чата с идентификатором = {conversation_id} )
    public String getMessagesByConversationId(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversation_id, Model model) {
        model.addAttribute(ModelAttributes.CONVERSATION_ID, conversation_id);
        List<AbstractMessage> abstractList = ConversationContext.getInstance().getConversationByUUID(conversation_id).getConversationMessages();
        ArrayList<TextMessage> messagesList = new ArrayList<>();
        for (AbstractMessage abstractMessage : abstractList) {
            messagesList.add((TextMessage) abstractMessage);
        }
        model.addAttribute(ModelAttributes.MESSAGES_LIST,messagesList);
        return Views.CONVERSATION;
    }



    @GetMapping(value = Endpoints.ADD_MESSAGE)
    public String messageAddForm(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversation_id, Model model) {
        model.addAttribute(ModelAttributes.CONVERSATION_ID, conversation_id);
        model.addAttribute(ModelAttributes.MESSAGE, new TextMessage());
        return Views.ADD_MESSAGE;
    }

    @PostMapping(value = Endpoints.ADD_MESSAGE)
    public String addMessageAndCheck(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversationId, @ModelAttribute TextMessage message, Model model) {
        model.addAttribute(ModelAttributes.MESSAGE, message);
        model.addAttribute(ModelAttributes.CONVERSATION_ID, conversationId.toString());
        // RANDOM DATA
        message.setTimeOfSending(new Date());
        message.setSenderUUID(UUID.randomUUID());
        // RANDOM DATA
        Conversation currentConversation = ConversationContext.getInstance().getConversationByUUID(conversationId);
        currentConversation.addMessage(message);
        return Views.ADD_MESSAGE_RESULT;
    }
}
