package com.messenger.model;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "conversation")
public class Conversation implements Serializable {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "conversation_id")
    private UUID conversationUUID;
    @Column
    private String conversationName;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID creatorUUID;

    @ManyToMany
    @JoinTable(name="conversations_members",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="conversation_id")})
    private List<User> membersUUIDList;

    public List<User> getMembersList() {
        return membersUUIDList;
    }
    public void setMembersList(List<User> membersUUIDList) {
        this.membersUUIDList = membersUUIDList;
    }


    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="conversation_id")
    private List<AbstractMessage> conversationMessages;


    public List<AbstractMessage> getConversationMessages() {
        return conversationMessages;
    }
    public void setConversationMessages(List<AbstractMessage> conversationMessages) {
        this.conversationMessages = conversationMessages;
    }


    public Conversation(UUID conversationUUID, String conversationName, User creatorUser) {
        this.conversationUUID = conversationUUID;
        this.conversationMessages = null;
        this.creatorUUID = creatorUUID;
        this.membersUUIDList = new ArrayList<>();
        this.addMemberByID(creatorUser);
        this.conversationName = conversationName;
    }


    public Conversation(UUID conversationUUID, String conversationName, List<User> membersUUIDList, UUID creatorUUID,
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

    public void addMemberByID(User user) {
        this.membersUUIDList.add(user);
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

    public void setConversationUUID(UUID conversationUUID) {
        this.conversationUUID = conversationUUID;
    }

    public void setCreatorUUID(UUID creatorUUID) {
        this.creatorUUID = creatorUUID;
    }

    public void removeMessageByID(UUID msgUUID){
        this.conversationMessages.removeIf(message -> message.getMessageId().equals(msgUUID));
    }
    public AbstractMessage getMessageByID(UUID msgUUID){
        for (AbstractMessage message:this.conversationMessages
             ) {
            if (message.getMessageId().equals(msgUUID))
                return message;
        }
        return null;
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
        for (int i = 0; i < this.getMembersList().size(); i++) {
            result.append(this.getMembersList().get(i).toString() + '\t');
        }
        result.append(" } ").append("}");
        return result.toString();
    }
}

