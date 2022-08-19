package org.itstep.accountmanager.writers;

import com.google.gson.*;
import org.itstep.accountmanager.account.Account;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter implements Writer {

    private static final String FILE_JSON = "accounts.json";

    @Override
    public void saveToFile(Account account) throws IOException {
        Gson gson = new GsonBuilder().create();
        String str = gson.toJson(account);

        try (FileWriter writer = new FileWriter(FILE_JSON, true)) {
            writer.write(str + System.lineSeparator());
        }
    }
}
