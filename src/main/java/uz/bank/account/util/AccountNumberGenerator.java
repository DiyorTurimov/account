package uz.bank.account.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AccountNumberGenerator {
    private static int nextId = 0;

    public static String retrieve(String currencyCode) {
        String accountPrefix = "20206";

        String key = "9";

        String accountNumber = String.format("%s%s%s%s%03d", accountPrefix, currencyCode, key, requestNibbd(), nextId++);

        return accountNumber;
    }

    private static String requestNibbd() {
        Random random = new Random();

        return String.format("%08d", random.nextInt(99999999));
    }
}
