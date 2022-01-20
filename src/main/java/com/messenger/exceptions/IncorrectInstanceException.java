package com.messenger.exceptions;

public class IncorrectInstanceException extends IllegalArgumentException {


    public IncorrectInstanceException(Object obj1, Class clazz){

        String string = "Incorrect argument class type input " + obj1.getClass().getCanonicalName() + "expected " + clazz.getCanonicalName();
        throw new IllegalArgumentException(string);
    }

}
