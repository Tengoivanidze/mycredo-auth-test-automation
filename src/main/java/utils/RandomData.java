package utils;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomData {

    private RandomData() {}

    public static String username() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public static String password() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
