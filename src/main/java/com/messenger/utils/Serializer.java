package com.messenger.utils;

import com.messenger.model.ConversationContext;

public interface Serializer {
    public static void serializeConversationContextToFile(ConversationContext conversationContext, String fileName){};
    public static void deserializeConversationContextFromFile(String fileName){};
}
