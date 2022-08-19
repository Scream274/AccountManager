package org.itstep.accountmanager.readers;

import org.itstep.accountmanager.account.Account;
import org.itstep.accountmanager.account.AccountConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonReader implements Reader {

    private static final String FILE_JSON = "accounts.json";

    @Override
    public List<Account> readFromFile() throws IOException {
        List<Account> accounts = new ArrayList<>();
        var accountStr = Files.readAllLines(Path.of(FILE_JSON));
        for (String str : accountStr) {
            accounts.add(AccountConverter.jsonToAccount(str));
        }
        return accounts;
    }
}
