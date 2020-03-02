package com.codechallenge.service.impl;

import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.service.AddressParser;
import com.codechallenge.vo.AddressVO;

import java.util.regex.Matcher;

import static com.codechallenge.utils.AddressRegexUtils.INTERNATIONAL_ADDRESS;
import static com.codechallenge.utils.AddressRegexUtils.getMatcher;

public class InternationalAddressParser implements AddressParser {
    @Override
    public AddressVO parse(String address) {

        Matcher matcher = getMatcher(INTERNATIONAL_ADDRESS, address.trim());
        if (matcher.matches()) {
            return new AddressVO(matcher.group(2), matcher.group(1));
        }
        throw new NoParserFoundException(address);
    }
}
