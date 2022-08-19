package org.itstep.accountmanager.readers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.itstep.accountmanager.account.Account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonReader implements Reader {

    private static final String FILE_JSON = "accounts.json";

    @Override
    public List<Account> readFromFile() throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy(HH:mm:ss)").create();
        List<Account> accounts = new ArrayList<>();
        var accountStr = Files.readAllLines(Path.of(FILE_JSON));
        for (String str : accountStr) {
            accounts.add(gson.fromJson(str, Account.class));
        }
        return accounts;
    }
}
