package com.messenger;

import com.messenger.exceptions.IncorrectInstanceException;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class TextMessage extends AbstractMessage implements Serializable {

    private String text;

    /* TODO: Можно создать конструктор без времени отправления и брать его как текущее время (= new java.util.Date()) */
    public TextMessage(String text, UUID senderUUID, Date timeOfSending){
        this.text = text;
        this.senderUUID = senderUUID;
        this.timeOfSending = timeOfSending;
    }

    public TextMessage() {
    }

    public String getText() {
        return text;
    }

    /* TODO: Что это?)) */
    public void setMessageTypeField(Object obj) {
        if(obj instanceof String) {
            this.text = (String) obj;
        }
        else
            throw new IncorrectInstanceException(obj,String.class);
    }


    public String getMessageTypeField() {
        return text;
    }

    @Override
    public String toString() {
        return "Message { " +
                "text = " + text  +
                ", senderId = " + senderUUID +
                ", timeOfSending = " + timeOfSending +
                '}';
    }





}
