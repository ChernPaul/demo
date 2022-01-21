package com.messenger;

import com.messenger.exceptions.Helper;
/* TODO: Ctrl + Alt + O */
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

    /* TODO: Может лучше pushBack? */
    public void addBack(Conversation conversation) {conversations.add(conversation);}


    @Override
    public String toString() {


        StringBuilder result = new StringBuilder();
        result.append("Conversations {" + '\n');

        for(int i = 0; i < conversations.size(); i++){
            /* TODO: Смесь аппенда с "+" */
            result.append(conversations.get(i).toString() + '\n');
        }
        result.append(" }");
        return result.toString();
    }


    /* TODO: Множественное число (conversations) */
    public List<UUID> getConversationUUIDByName(String name, double percentage){

        List<UUID> result = new ArrayList<>();

        /* TODO: foreach? */
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
        /* TODO: foreach */
        for (int i = 0; i < this.conversations.size(); i++) {
            /* TODO: foreach */
            for (int j = 0; i < conversations.get(i).getConversationMessages().size(); j++) {

                /* TODO: Слишком длинная цепочка вызовов */
                Date msgDate = this.getConversations().get(i).getConversationMessages().get(j).getTimeOfSending();
                if (msgDate.before(date))
                    /* TODO: Слишком длинная цепочка вызовов */
                    result.add(this.getConversations().get(i).getConversationMessages().get(j));
            }
        }
        return result;
    }


    public Conversation getConversationByUUID(UUID id){
        Conversation result = null;
        /* TODO: foreach */
        for (int i =0; i< this.conversations.size(); i++){
            /* TODO: Слишком длинная цепочка вызовов */
            if(this.getConversations().get(i).getConversationUUID().equals(id))
                return this.getConversations().get(i);
        }
        return null;
        } /* TODO: Форматирование кода Ctrl + Alt + L */


}
