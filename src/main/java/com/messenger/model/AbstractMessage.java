package com.messenger.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.messenger.constants.ModelConstants;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = ModelConstants.TYPE)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = ModelConstants.TEXT_MESSAGE)

})
@MappedSuperclass
public abstract class AbstractMessage implements Serializable {

    @Id
    @Column(name = "id")
    protected UUID id;
    @Column(name = "sender_UUID")
    protected UUID senderUUID;
    @Column(name = "time_of_sending")
    protected Date timeOfSending;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSenderUUID() {
        return senderUUID;
    }
    public Date getTimeOfSending() {return timeOfSending;    }
    public void setSenderUUID(UUID senderID) {
        this.senderUUID = senderID;
    }
    public void setTimeOfSending(Date timeOfSending) {
        this.timeOfSending = timeOfSending;
    }

}
