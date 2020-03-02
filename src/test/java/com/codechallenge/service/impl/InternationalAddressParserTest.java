package com.codechallenge.service.impl;

import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.service.AddressParser;
import com.codechallenge.vo.AddressVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternationalAddressParserTest {
    private AddressParser addressParser = new InternationalAddressParser();

    @Test
    void correctGermanAddress() {
        AddressVO result = addressParser.parse("200 Broadway Av");
        assertNotNull(result);
        assertNotNull(result.getStreet());
        assertNotNull(result.getHousenumber());
    }

    @Test
    void notGermanAddress() {
        assertThrows(NoParserFoundException.class, () -> addressParser.parse("Calle Aduana, 29"));
    }
}