package com.codechallenge.service;

import com.codechallenge.vo.AddressVO;

public interface AddresslineService {
    AddressVO splitStreetAndNumber(String address);
}
