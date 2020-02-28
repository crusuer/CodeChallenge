package com.codechallenge.service.impl;

import com.codechallenge.service.AddressParser;
import com.codechallenge.vo.AddressVO;

public class GermanAddressParser implements AddressParser {
    @Override
    public AddressVO parse(String address) {
        String[] split = address.split(" ");
        return new AddressVO(split[0], split[1]);
    }
}
