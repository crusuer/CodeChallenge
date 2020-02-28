package com.codechallenge.exception;

public class NotEnoughArgsException extends IllegalArgumentException {
    public NotEnoughArgsException(){
        super("Not enough arguments, provide the address to be parsed");
    }
}
