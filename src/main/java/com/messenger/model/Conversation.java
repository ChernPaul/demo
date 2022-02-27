package com.messenger.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Conversation implements Serializable {
    private UUID conversationUUID;
    private String conversationName;
    private List<UUID> membersUUIDList;
    private UUID creatorUUID;
    private List<AbstractMessage> conversationMessages;

    public Conversation(UUID conversationUUID, String conversationName, UUID creatorUUID) {
        this.conversationUUID = conversationUUID;
        this.conversationMessages = null;
        this.creatorUUID = creatorUUID;
        this.membersUUIDList = new ArrayList<>();
        this.addMemberByID(creatorUUID);
        this.conversationName = conversationName;
    }


    public Conversation(UUID conversationUUID, String conversationName, List<UUID> membersUUIDList, UUID creatorUUID,
                        List<AbstractMessage> conversationMessages) {
        this.conversationUUID = conversationUUID;
        this.conversationMessages = conversationMessages;
        this.membersUUIDList = membersUUIDList;

        if (membersUUIDList.contains(creatorUUID)) {
            this.creatorUUID = creatorUUID;
        } else
            throw new IllegalArgumentException();
        this.conversationName = conversationName;
    }

    public Conversation() {

        this.conversationUUID = null;
        this.conversationMessages = new ArrayList<>();
        this.creatorUUID =  null;
        this.membersUUIDList = new ArrayList<>();
        this.conversationName = null;
    }


    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }
    public String getConversationName() {
        return conversationName;
    }

    public void addMemberByID(UUID id) {
        this.membersUUIDList.add(id);
    }
    public void removeMemberByID(UUID id) {
        this.membersUUIDList.remove(id);
    }

    public void addMessage(AbstractMessage message) {
        this.conversationMessages.add(message);
    }

    public void removeMessage(AbstractMessage message) {
        this.membersUUIDList.remove(message);
    }

    public UUID getConversationUUID() {
        return conversationUUID;
    }

    public UUID getCreatorUUID() {
        return creatorUUID;
    }

    public List<AbstractMessage> getConversationMessages() {
        return conversationMessages;
    }

    public List<UUID> getMembersUUIDList() {
        return membersUUIDList;
    }

    public void setConversationUUID(UUID conversationUUID) {
        this.conversationUUID = conversationUUID;
    }

    public void setConversationMessages(List<AbstractMessage> conversationMessages) {
        this.conversationMessages = conversationMessages;
    }
    public void setCreatorUUID(UUID creatorUUID) {
        this.creatorUUID = creatorUUID;
    }

    public void setMembersUUIDList(List<UUID> membersUUIDList) {
        this.membersUUIDList = membersUUIDList;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("Conversation { ").append("conversationMessages = { ");
        for (int i = 0; i < this.getConversationMessages().size(); i++) {
            result.append(this.getConversationMessages().get(i).toString() + '\t');
        }
        result.append(" } ").append("conversationId = ").append(conversationUUID);
        result.append("conversationName = ").append(conversationName);
        result.append("creatorId = ").append(creatorUUID).append("membersIdList = { ");
        for (int i = 0; i < this.getMembersUUIDList().size(); i++) {
            result.append(this.getMembersUUIDList().get(i).toString() + '\t');
        }
        result.append(" } ").append("}");
        return result.toString();
    }
}

