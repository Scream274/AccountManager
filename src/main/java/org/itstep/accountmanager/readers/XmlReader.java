package org.itstep.accountmanager.readers;

import org.itstep.accountmanager.account.Account;
import org.itstep.accountmanager.account.AccountConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements Reader{

    private static final String FILE_XML = "accounts.xml";

    @Override
    public List<Account> readFromFile() throws IOException {
        List<Account> accounts = new ArrayList<>();
        var accountsStrings = Files.readAllLines(Path.of(FILE_XML));

        for(String str: accountsStrings){
            accounts.add(AccountConverter.xmlToAccount(str));
        }

        return accounts;
    }
}
