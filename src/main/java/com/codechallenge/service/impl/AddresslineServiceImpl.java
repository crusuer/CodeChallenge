package com.codechallenge.service.impl;

import com.codechallenge.exception.AddressNullOrEmptyException;
import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.service.AddressParser;
import com.codechallenge.service.AddresslineService;
import com.codechallenge.utils.AddressRegexUtils;
import com.codechallenge.vo.AddressVO;
import org.springframework.stereotype.Service;

@Service
public class AddresslineServiceImpl implements AddresslineService {
    @Override
    public AddressVO splitStreetAndNumber(String address) {
        if (address == null || address.isEmpty()) {
            throw new AddressNullOrEmptyException();
        }

        AddressParser addressParser;
        if (address.matches(AddressRegexUtils.GERMAN_ADDRESS)) {
            addressParser = new GermanAddressParser();
        } else if (address.matches(AddressRegexUtils.INTERNATIONAL_ADDRESS)) {
            addressParser = new InternationalAddressParser();
        } else {
            throw new NoParserFoundException(address);
        }

        return addressParser.parse(address);
    }
}
