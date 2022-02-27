package com.messenger.utils;
import com.messenger.model.ConversationContext;
import java.io.*;

public class DataProcessing implements Serializable {

    public static File getFileByFilename(String fileName){
        File file = new File(fileName);
        return file;
    }

    public static void serializeConversations(ConversationContext conversationContext, OutputStream out) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(conversationContext);
    }

    public static ConversationContext deserializeConversations(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream inpStream = new ObjectInputStream(in);
        ConversationContext result = (ConversationContext)inpStream.readObject();
        return result;
    }

}
