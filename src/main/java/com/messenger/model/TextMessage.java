package com.messenger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "text_message")
public class TextMessage extends AbstractMessage implements Serializable {
    @Column(name = "content")
    private String text;

    public TextMessage(String text, UUID userId, Date timeOfSending){
        this.text = text;
        this.userId = userId;
        this.timeOfSending = timeOfSending;
        this.messageId = UUID.randomUUID();
    }

    public TextMessage(UUID messageId, String text, UUID userId, Date timeOfSending) {
        this.text = text;
        this.userId = userId;
        this.timeOfSending = timeOfSending;
        this.messageId = messageId;
    }

    public TextMessage(String text, UUID userId){
        this.text = text;
        this.userId = userId;
        this.timeOfSending = new java.util.Date();
        this.messageId = UUID.randomUUID();
    }
    public TextMessage(String text) {
        this.text = text;
        this.userId = UUID.randomUUID();
        this.timeOfSending = new java.util.Date();
        this.messageId = UUID.randomUUID();
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public TextMessage() {}

    @Override
    public String toString() {
        return "Message { " +
                "text = " + text  +
                ", senderId = " + userId +
                ", timeOfSending = " + timeOfSending +
                '}';
    }


}
