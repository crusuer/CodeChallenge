package com.codechallenge.exception;

public class NoParserFoundException extends RuntimeException {
    public NoParserFoundException(String address) {
        super(String.format("No parser found for address %s", address));
    }
}
