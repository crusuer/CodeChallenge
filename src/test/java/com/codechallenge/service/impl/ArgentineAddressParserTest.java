package com.codechallenge.service.impl;

import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.service.AddressParser;
import com.codechallenge.vo.AddressVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgentineAddressParserTest {

    private AddressParser addressParser = new ArgentineAddressParser();

    @Test
    void correctArgentineAddress() {
        AddressVO result = addressParser.parse("Calle 39 Number 1540");
        assertNotNull(result);
        assertNotNull(result.getStreet());
        assertNotNull(result.getHousenumber());
    }

    @Test
    void notArgentineAddress() {
        assertThrows(NoParserFoundException.class, () -> addressParser.parse("Blaufeldweg 123B"));
    }
}