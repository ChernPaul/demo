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
        public static final String MESSAGE_ID = "message_id";
    }
    private static class Views{
        public static final String ADD_MESSAGE = "addMessage";
        public static final String CONVERSATION = "viewConversation";
        public static final String ADD_MESSAGE_RESULT = "addMessageResult";
        public static final String UPDATE_MESSAGE = "updateMessage";
        public static final String UPDATE_MESSAGE_RESULT = "updateMessageResult";
        public static final String DELETE_MESSAGE = "deleteMessage";


    }

    private static class ModelAttributes{
        public static final String MESSAGE = "message";
        public static final String MESSAGES_LIST = "messages_list";
        public static final String CONVERSATION_ID = "conversation_id";
        public static final String MESSAGE_ID = "message_id";
    }

    private static class Endpoints{
        public static final String UPDATE_MESSAGE = "/{message_id}/update";
        public static final String DELETE_MESSAGE = "/{message_id}/delete";
        public static final String ADD_MESSAGE = "/add";

    }

    @GetMapping
    // /conversations/{conversation_id}/messages (все сообщения чата с идентификатором = {conversation_id} )
    public String getMessagesByConversationId(@PathVariable(PathVariables.CONVERSATION_ID)
                                                          UUID conversation_id, Model model) {
        model.addAttribute(ModelAttributes.CONVERSATION_ID, conversation_id);
        List<AbstractMessage> abstractList =
                ConversationContext.getInstance().getConversationByUUID(conversation_id).getConversationMessages();
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
    public String addMessageAndCheck(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversationId,
                                     @ModelAttribute TextMessage message, Model model) {
        model.addAttribute(ModelAttributes.MESSAGE, message);
        model.addAttribute(ModelAttributes.CONVERSATION_ID, conversationId.toString());
        // RANDOM DATA
        message.setMessageId(UUID.randomUUID());
        message.setTimeOfSending(new Date());
        message.setUserId(UUID.randomUUID());
        // RANDOM DATA
        Conversation currentConversation = ConversationContext.getInstance().getConversationByUUID(conversationId);
        currentConversation.addMessage(message);
        return Views.ADD_MESSAGE_RESULT;
    }


    @GetMapping(value = Endpoints.DELETE_MESSAGE)
    public String messageDeleteForm(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversation_id,
                                    @PathVariable(PathVariables.MESSAGE_ID) UUID message_id, Model model) {
       Conversation currentConversation = ConversationContext.getInstance().getConversationByUUID(conversation_id);
       if (currentConversation != null)
           currentConversation.removeMessageByID(message_id);
       return Views.DELETE_MESSAGE;
    }

    //

    @GetMapping(value = Endpoints.UPDATE_MESSAGE)
    public String messageUpdateForm(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversationId,
                                    @PathVariable(PathVariables.MESSAGE_ID) UUID message_id, Model model) {
        model.addAttribute(ModelAttributes.CONVERSATION_ID, conversationId.toString());
        model.addAttribute(ModelAttributes.MESSAGE_ID, message_id);
        model.addAttribute(ModelAttributes.MESSAGE, new TextMessage());
        return Views.UPDATE_MESSAGE;
    }

    @PostMapping(value = Endpoints.UPDATE_MESSAGE)
    public String updateMessageAndCheck(@PathVariable(PathVariables.CONVERSATION_ID) UUID conversationId,
                                        @PathVariable(PathVariables.MESSAGE_ID) UUID message_id,
                                        @ModelAttribute TextMessage message, Model model) {
        model.addAttribute(ModelAttributes.MESSAGE, message);

        TextMessage updatedMessage = (TextMessage) ConversationContext.getInstance().getConversationByUUID(conversationId).getMessageByID(message_id);
        updatedMessage.setText(message.getText());
        return Views.UPDATE_MESSAGE_RESULT;
    }

}
