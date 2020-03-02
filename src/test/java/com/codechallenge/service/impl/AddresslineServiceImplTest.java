package com.codechallenge.service.impl;

import com.codechallenge.exception.AddressNullOrEmptyException;
import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.service.AddresslineService;
import com.codechallenge.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AddresslineServiceImpl.class)
class AddresslineServiceImplTest {

    @Autowired
    private AddresslineService addresslineService;

    @Test
    void testSimpleCaseOne() {
        String address = "Winterallee 3";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Winterallee", result.getStreet());
        assertEquals("3", result.getHousenumber());
    }

    @Test
    void testSimpleCaseTwo() {
        String address = "Musterstrasse 45";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Musterstrasse", result.getStreet());
        assertEquals("45", result.getHousenumber());
    }

    @Test
    void testSimpleCaseThree() {
        String address = "Blaufeldweg 123B";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Blaufeldweg", result.getStreet());
        assertEquals("123B", result.getHousenumber());
    }

    @Test
    void testComplicatedCaseOne() {
        String address = "Am Bächle 23";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Am Bächle", result.getStreet());
        assertEquals("23", result.getHousenumber());
    }

    @Test
    void testComplicatedCaseTwo() {
        String address = "Auf der Vogelwiese 23 b";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Auf der Vogelwiese", result.getStreet());
        assertEquals("23 b", result.getHousenumber());
    }

    @Test
    void testOtherCountryCaseOne() {
        String address = "4, rue de la revolution";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("rue de la revolution", result.getStreet());
        assertEquals("4", result.getHousenumber());
    }

    @Test
    void testOtherCountryCaseTwo() {
        String address = "200 Broadway Av";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Broadway Av", result.getStreet());
        assertEquals("200", result.getHousenumber());
    }

    @Test
    void testOtherCountryCaseThree() {
        String address = "Calle Aduana, 29";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Calle Aduana", result.getStreet());
        assertEquals("29", result.getHousenumber());
    }

    @Test
    void testOtherCountryCaseFour() {
        String address = "Calle 39 No 1540";
        AddressVO result = addresslineService.splitStreetAndNumber(address);

        assertEquals("Calle 39", result.getStreet());
        assertEquals("No 1540", result.getHousenumber());
    }

    @Test
    void testAddressWithoutParser() {
        String address = "Hollywood street";

        assertThrows(NoParserFoundException.class, () -> addresslineService.splitStreetAndNumber(address));
    }

    @Test
    void testBlankAddress() {
        String address = " ";

        assertThrows(NoParserFoundException.class, () -> addresslineService.splitStreetAndNumber(address));
    }

    @Test
    void testNullAddress() {
        String address = null;

        assertThrows(AddressNullOrEmptyException.class, () -> addresslineService.splitStreetAndNumber(address));
    }

    @Test
    void testEmptyAddress() {
        String address = "";

        assertThrows(AddressNullOrEmptyException.class, () -> addresslineService.splitStreetAndNumber(address));
    }
}