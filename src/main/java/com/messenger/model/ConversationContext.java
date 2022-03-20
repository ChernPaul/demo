package com.messenger.model;

import com.messenger.utils.Helper;

import java.io.Serializable;
import java.util.*;

public class ConversationContext implements Serializable {


    private ConversationContext() {
        this.conversations = null;
    }


    private static class SingletonHolder {
        private final static ConversationContext instance = new ConversationContext();
    }

    public static ConversationContext getInstance() {
        return SingletonHolder.instance;
    }


    private List<Conversation> conversations;

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    public void removeConversationByID(UUID conversationId){
        this.getConversations().removeIf(conversation -> conversation.getConversationUUID().equals(conversationId));
    }


    public void pushBack(Conversation conversation) {
        conversations.add(conversation);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("ConversationContext {").append('\n');
        for (int i = 0; i < conversations.size(); i++) {
            result.append(conversations.get(i).toString()).append('\n').append(" }");
        }
        return result.toString();
    }


    public List<UUID> getConversationsUUIDByName(String name, double percentage) {
        List<UUID> result = new ArrayList<>();
        for (Conversation conversation: this.conversations) {
            String convName = conversation.getConversationName();
            double curPercentage = (double) Helper.StrCompare(convName, name) / name.length();
            if (curPercentage > percentage)
                result.add(conversation.getConversationUUID());
        }
        return result;
    }

    public List<AbstractMessage> getMessagesByDate(Date date) {
        List<AbstractMessage> result = new ArrayList<>();
        for (Conversation conversation: this.conversations) {
            for (AbstractMessage message: conversation.getConversationMessages()) {
                Date msgDate = message.getTimeOfSending();
                if (msgDate.before(date))
                    result.add(message);
            }
        }
        return result;
    }

    public Conversation getConversationByUUID(UUID id) {
        for (Conversation conversation: this.getConversations()) {
            if (conversation.getConversationUUID().equals(id)) {
                return conversation;
            }
        }
        return null;
    }


}
