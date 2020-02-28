package com.codechallenge.vo;

import com.google.gson.Gson;
import lombok.Value;

@Value
public class AddressVO {
    private String street;
    private String housenumber;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
