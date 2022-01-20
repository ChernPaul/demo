package com.messenger;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;



public class Conversation implements Serializable {
    private UUID conversationUUID;
    private String conversationName;
    private List<UUID> membersUUIDList;
    private UUID creatorUUID;
    private List<AbstractMessage> conversationMessages; //Imessage

    public Conversation(UUID conversationUUID, String conversationName, List<UUID> membersUUIDList, UUID creatorUUID,  List<AbstractMessage> conversationMessages){
        this.conversationUUID = conversationUUID;
        this.conversationMessages = conversationMessages;
        this.creatorUUID = creatorUUID;
        this.membersUUIDList = membersUUIDList;
        this.conversationName = conversationName;
    }

    public Conversation() {

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

    public String getConversationName() {
        return conversationName;
    }

    public void setConversationUUID(UUID conversationUUID) {
        this.conversationUUID = conversationUUID;
    }

    public void setConversationMessages(List<AbstractMessage> conversationMessages) {
        this.conversationMessages = conversationMessages;
    }

    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
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
        result.append("Conversation { ");
        result.append("conversationMessages = { ");
        for(int i = 0; i < this.getConversationMessages().size(); i++){
            result.append(this.getConversationMessages().get(i).toString() + '\t');
        }
        result.append(" } ");
        result.append("conversationId = " + conversationUUID);
        result.append("conversationName = " + conversationName);
        result.append("creatorId = "  + creatorUUID);
        result.append("membersIdList = { ");
        for(int i = 0; i < this.getMembersUUIDList().size(); i++){
            result.append(this.getMembersUUIDList().get(i).toString() + '\t');
        }
        result.append(" } ");
        result.append("}");
        return result.toString();
    }

}

