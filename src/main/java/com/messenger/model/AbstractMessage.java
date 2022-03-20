package com.messenger.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.messenger.constants.ModelConstants;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = ModelConstants.TYPE)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = ModelConstants.TEXT_MESSAGE)

})

@Inheritance
@Entity
public abstract class AbstractMessage implements Serializable {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "message_id")
    protected UUID messageId;
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "user_id")
    protected UUID userId;
    @Column(name = "time_of_sending")
    protected Date timeOfSending;


    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getUserId(){
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getTimeOfSending() {return timeOfSending;}
    public void setTimeOfSending(Date timeOfSending) {
        this.timeOfSending = timeOfSending;
    }

}
