package com.shrtcut.shrtcut.util;

import java.security.SecureRandom;

public class ShortCodeGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;

    public static String generate() {
        SecureRandom random = new SecureRandom();     //Java class used for cryptographically strong random number generation
        //Use getInstanceStrong() when high security is required
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
