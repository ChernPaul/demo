package com.messenger;

import com.messenger.exceptions.Helper;

import java.util.ArrayList;
import java.util.UUID;

public class Users {

    /* TODO: Заменить на коллекцию */
    /* FIXME: users */
    private User[] usrs;

    /* TODO: Использовать конкретную реализацию как тип возвращаемого объекта не целесообразно */
    /*  hint: используй интерфейсы, если они есть. Пример: ArrayList -> List */
    public ArrayList<UUID> getUserUUIDByName(String name, double percentage){

        // TODO: ArrayList -> List
        ArrayList<UUID> result = new ArrayList<>();

        // TODO: foreach
        for (int i =0; i< this.usrs.length; i++){

            String convName = this.usrs[i].getUserName();
            double curPercentage = (double) Helper.StrCompare(convName,name)/name.length();
            if(curPercentage > percentage)
                result.add(this.usrs[i].getUserUUID());

        }
        return  result;
    }

}
