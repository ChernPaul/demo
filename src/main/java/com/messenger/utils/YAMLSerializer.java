package com.messenger.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.messenger.model.ConversationContext;
import java.io.IOException;
import static com.messenger.utils.DataProcessing.getFileByFilename;

public class YAMLSerializer implements Serializer {

    public static void serializeConversationContextToFileYAML(ConversationContext conversationContext, String fileName)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(getFileByFilename(fileName), conversationContext);
    }

    public static ConversationContext deserializeConversationContextFromFileYAML(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(getFileByFilename(fileName), ConversationContext.class);
    }


}
