package com.codechallenge.exception;

public class AddressNullOrEmptyException extends RuntimeException {
    public AddressNullOrEmptyException() {
        super("Address is null or empty and can not be parsed");
    }
}
