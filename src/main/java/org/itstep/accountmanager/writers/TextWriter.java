package org.itstep.accountmanager.writers;

import org.itstep.accountmanager.account.Account;
import org.itstep.accountmanager.account.AccountConverter;

import java.io.FileWriter;
import java.io.IOException;

public class TextWriter implements Writer {

    private static final String FILE_TXT = "accounts.txt";

    @Override
    public void saveToFile(Account account) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_TXT, true)) {
            writer.write(AccountConverter.accountToString(account) + System.lineSeparator());
        }
    }
}
