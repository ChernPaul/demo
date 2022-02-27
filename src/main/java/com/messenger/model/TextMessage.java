package com.messenger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

// text_message   id sender_UUID"

//    @Column(name = "time_of_sending")


@Entity
@Table(name = "text_message")
public class TextMessage extends AbstractMessage implements Serializable {
    @Column(name = "content")
    private String text;

    public TextMessage(String text, UUID senderUUID, Date timeOfSending){
        this.text = text;
        this.senderUUID = senderUUID;
        this.timeOfSending = timeOfSending;
    }

    public TextMessage(UUID id, String text, UUID senderUUID, Date timeOfSending) {
        this.text = text;
        this.senderUUID = senderUUID;
        this.timeOfSending = timeOfSending;
        this.id = id;
    }

    public TextMessage(String text, UUID senderUUID){
        this.text = text;
        this.senderUUID = senderUUID;
        this.timeOfSending = new java.util.Date();
    }
    public TextMessage(String text) {
        this.text = text;
        this.senderUUID = UUID.randomUUID();
        this.timeOfSending = new java.util.Date();
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
                ", senderId = " + senderUUID +
                ", timeOfSending = " + timeOfSending +
                '}';
    }


}
