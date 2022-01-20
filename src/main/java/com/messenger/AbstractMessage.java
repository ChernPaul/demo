package com.messenger;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;



@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = "TextMessage")
        //,@JsonSubTypes.Type(value = Cat.class, name = "cat")
})

public abstract class AbstractMessage implements Serializable {

    protected UUID senderUUID;
    protected Date timeOfSending;


    public UUID getSenderUUID() {
        return senderUUID;
    }
    public Date getTimeOfSending() {
        return timeOfSending;
    }

}
