package com.messenger;

import com.messenger.exceptions.Helper;

import java.io.Serializable;
import java.util.*;

public class Conversations implements Serializable {

    private Conversations(){this.conversations = null;}
    private static class SingletonHolder{
        private final static  Conversations instance = new Conversations();
    }

    public static  Conversations getInstance(){
        return  SingletonHolder.instance;
    }

    private  List<Conversation> conversations;

    public List<Conversation> getConversations() {return conversations;}
    public void setConversations(List<Conversation> conversations) {this.conversations = conversations;}
    public void addBack(Conversation conversation) {conversations.add(conversation);}


    @Override
    public String toString() {


        StringBuilder result = new StringBuilder();
        result.append("Conversations {" + '\n');

        for(int i = 0; i < conversations.size(); i++){
            result.append(conversations.get(i).toString() + '\n');
        }
        result.append(" }");
        return result.toString();
    }



    public List<UUID> getConversationUUIDByName(String name, double percentage){

        List<UUID> result = new ArrayList<>();
        for (int i =0; i< this.conversations.size(); i++){

            String convName = this.getConversations().get(i).getConversationName();
            double curPercentage = (double) Helper.StrCompare(convName,name)/name.length();
            if(curPercentage > percentage)
                result.add(this.getConversations().get(i).getConversationUUID());
        }
        return  result;
    }

    public List<AbstractMessage> getMessagesByDate(Date date) {

        List<AbstractMessage> result = new ArrayList<>();

        for (int i = 0; i < this.conversations.size(); i++) {

            for (int j = 0; i < conversations.get(i).getConversationMessages().size(); j++) {
                Date msgDate = this.getConversations().get(i).getConversationMessages().get(j).getTimeOfSending();
                if (msgDate.before(date))
                    result.add(this.getConversations().get(i).getConversationMessages().get(j));
            }
        }
        return result;
    }


    public Conversation getConversationByUUID(UUID id){
        Conversation result = null;
        for (int i =0; i< this.conversations.size(); i++){
            if(this.getConversations().get(i).getConversationUUID().equals(id))
                return this.getConversations().get(i);
        }
        return null;
        }


}
