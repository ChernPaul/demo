package com.messenger.exceptions;

public class Helper {

    public static int StrCompare(String str1, String str2){
        int result = 0;
        int len = str1.length();
        if (len < str2.length()){
            len = str2.length();
        }
        char[] arrChar1 = str1.toCharArray();
        char[] arrChar2 = str2.toCharArray();

        for(int i = 0; i < len; i++){

            if(arrChar1[i] == arrChar2[i])
                result++;
        }

        return result;
    }


}
