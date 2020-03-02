package com.codechallenge.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressRegexUtils {
    public static final String GERMAN_ADDRESS = "(\\D+) (\\d+[\\s]*[\\w]*)";//"^([^0-9]+) ([\\w]+\\s?[a-zA-Z]?)";
    public static final String INTERNATIONAL_ADDRESS = "(\\d+) ([\\s]*\\D+)";//"^([\\w]+) ([^0-9]+)";
    public static final String INTERNATIONAL_ADDRESS_WITH_TEXT_NUMBER = "(?= (?i)(No|Number)\\s\\d+)";
    public static final String ADDRESS_WITH_TEXT_NUMBER = "(?= (?i)No|Number)";

    public static Matcher getMatcher(String regex, String address) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(address);
    }
}
