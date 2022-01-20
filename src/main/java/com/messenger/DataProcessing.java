package com.messenger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataProcessing implements Serializable {

    public static void serializeConversations(Conversations conversations, OutputStream out){

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(conversations);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

    }

    public static Conversations deserializeConversations(InputStream in){
        Conversations conversations = null;
        ObjectInputStream inpStream = null;
        try {
            inpStream = new ObjectInputStream(in);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        try{
            assert inpStream != null;
            conversations = (Conversations)inpStream.readObject();
        }
        catch (IOException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return conversations;
    }

    public static void serializeConversationsToJSON(OutputStream out, Conversations conversations){

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue( out, conversations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Conversations deserializeConversationsFromJSONFile(String  fileName) throws IOException {
        String result;
        Path path = Paths.get(fileName);
        byte[] allBytesFromFile = Files.readAllBytes(path);
        result = new String(allBytesFromFile);
        return deserializeConversationsFromStringJSON(result);
    }

    public static String serializeConversationsToStringJSON(Conversations conversations){

        StringBuilder result = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        try {
            result.append(mapper.writeValueAsString(conversations));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return result.toString();
    }

    public static Conversations deserializeConversationsFromStringJSON(String jsonString) throws JsonProcessingException {

        Conversations result;
        ObjectMapper mapper = new ObjectMapper();

            result = mapper.readValue(jsonString,Conversations.class);


        return result;
    }

    /* public static List<Conversation> deserializeСonversationArrayFromJSONFile(String  fileName) throws IOException {

        String jsonString;
        Path path = Paths.get(fileName);
        byte[] allBytesFromFile = Files.readAllBytes(path);
        jsonString = new String(allBytesFromFile);
        ObjectMapper mapper = new ObjectMapper();
        List<Conversation> result = new ArrayList<>();

        result.add(mapper.readValue(jsonString,ArrayList<Conversation.class>));
        return result;

    }
    */

    public static Conversations deserializeConversationsFromFileYAML(String fileName) throws IOException {

        File file = new File(fileName);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(file, Conversations.class);

    }
    //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public static void serializeConversationsToFileYAML(Conversations conversations, String fileName) throws IOException {
        File file = new File(fileName);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(file, conversations);

    }

}
