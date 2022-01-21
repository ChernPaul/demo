package com.messenger;


import java.io.Serializable;
/* TODO: Ctrl + Alt + O */
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

    /* TODO: Создать конструктор без участников и сообщений */
    /* TODO: Слишком длинная строка. Ориентируйся на вертикальную прямую (вот эту -------------------------------------> */
    public Conversation(UUID conversationUUID, String conversationName, List<UUID> membersUUIDList, UUID creatorUUID,  List<AbstractMessage> conversationMessages){
        this.conversationUUID = conversationUUID;
        this.conversationMessages = conversationMessages;
        this.creatorUUID = creatorUUID;
        this.membersUUIDList = membersUUIDList;
        this.conversationName = conversationName;

        /* TODO: А что если на вход подадут список участников, в которых нет создателя? */
    }

    public Conversation() {

    }

    /* TODO: Создать методы добавления, удаления, редактирования сообщения */
    /* TODO: Создать методы добавления, удаления участников */

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
        /* TODO: Можно без "+" */
        result.append("conversationId = ").append(conversationUUID);
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

