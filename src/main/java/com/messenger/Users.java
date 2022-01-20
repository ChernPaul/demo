package com.messenger;

import com.messenger.exceptions.Helper;

import java.util.ArrayList;
import java.util.UUID;

public class Users {

    private User[] usrs;
    public ArrayList<UUID> getUserUUIDByName(String name, double percentage){

        ArrayList<UUID> result = new ArrayList<>();
        for (int i =0; i< this.usrs.length; i++){

            String convName = this.usrs[i].getUserName();
            double curPercentage = (double) Helper.StrCompare(convName,name)/name.length();
            if(curPercentage > percentage)
                result.add(this.usrs[i].getUserUUID());

        }
        return  result;
    }

}
