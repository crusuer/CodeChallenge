package com.codechallenge.service;

import com.codechallenge.exception.NoParserFoundException;
import com.codechallenge.vo.AddressVO;

public interface AddresslineService {
    AddressVO splitStreetAndNumber(String address) throws NoParserFoundException;
}
