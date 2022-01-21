package com.messenger;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/* TODO: Почитать про POJO (Plain Old Java Object). Это сущность, как и Conversation. Их нужно в отдельный пакет */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type" /* TODO: в константы */)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = "TextMessage" /* TODO: в константы */)
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

    /* TODO: А где сеттеры?((( */

}
