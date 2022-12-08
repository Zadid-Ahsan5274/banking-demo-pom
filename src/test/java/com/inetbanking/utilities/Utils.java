package com.inetbanking.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String generateRandomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }

    public static String generatedRandomNum(){
        String generatedString2 = RandomStringUtils.randomAlphabetic(4);
        return generatedString2;
    }
}
