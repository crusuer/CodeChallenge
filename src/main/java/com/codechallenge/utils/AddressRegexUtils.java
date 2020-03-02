package com.codechallenge.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressRegexUtils {
    public static final String INTERNATIONAL_ADDRESS = "(\\d+) ([\\s]*\\D+)";
    public static final String GERMAN_ADDRESS = "(\\D+) (\\d+[\\s]*[\\w]*)";
    public static final String ARGENTINE_ADDRESS = "([\\w\\s]+) (No.*|Number.*|no.*|number.*)";

    public static Matcher getMatcher(String regex, String address) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(address);
    }
}
