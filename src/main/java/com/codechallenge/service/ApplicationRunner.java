package com.codechallenge.service;

import com.codechallenge.exception.NotEnoughArgsException;
import com.codechallenge.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private AddresslineService addresslineService;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            throw new NotEnoughArgsException();
        }
        AddressVO addressParsed = addresslineService.splitStreetAndNumber(args[0]);
        System.out.println(addressParsed);
    }
}
