package com.codechallenge.service.impl;

import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.service.AddressParser;
import com.codechallenge.vo.AddressVO;

import java.util.regex.Matcher;

import static com.codechallenge.utils.AddressRegexUtils.*;

public class GermanAddressParser implements AddressParser {
    @Override
    public AddressVO parse(String address) {

        Matcher matcher = getMatcher(GERMAN_ADDRESS, address);
        if (matcher.matches()) {
            return new AddressVO(matcher.group(1), matcher.group(2));
        }
        throw new NoParserFoundException(address);
    }
}
