package com.messenger.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messenger.model.ConversationContext;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONSerializer implements Serializer {

    public static void serializeConversationsToJSON(OutputStream out, ConversationContext conversationContext)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, conversationContext);
    }

    public static ConversationContext deserializeConversationsFromJSONFile(String  fileName)
            throws IOException {
        String result;
        Path path = Paths.get(fileName);
        byte[] allBytesFromFile = Files.readAllBytes(path);
        result = new String(allBytesFromFile);
        return deserializeConversationsFromStringJSON(result);
    }

    public static String serializeConversationsToStringJSON(ConversationContext conversationContext)
            throws JsonProcessingException {
        StringBuilder result = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        result.append(mapper.writeValueAsString(conversationContext));
        return result.toString();
    }

    public static ConversationContext deserializeConversationsFromStringJSON(String jsonString)
            throws JsonProcessingException {
        ConversationContext result;
        ObjectMapper mapper = new ObjectMapper();
        result = mapper.readValue(jsonString, ConversationContext.class);
        return result;
    }


}
