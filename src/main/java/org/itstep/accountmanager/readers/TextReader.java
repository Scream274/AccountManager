package org.itstep.accountmanager.readers;

import org.itstep.accountmanager.account.Account;
import org.itstep.accountmanager.account.AccountBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TextReader implements Reader {

    private static final String FILE_TXT = "accounts.txt";

    @Override
    public List<Account> readFromFile() throws IOException {
        List<Account> accounts = new ArrayList<>();
        var accountStr = Files.readAllLines(Path.of(FILE_TXT));
        for (String str : accountStr) {
            accounts.add(stringToAccount(str));
        }
        return accounts;
    }

    private Account stringToAccount(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy(HH:mm:ss)");
        var accounts = input.split(" ");
        Account account;
        AccountBuilder ab = new AccountBuilder();
        account = ab.setLogin(accounts[0]).setEmail(accounts[1]).
                setPassword(accounts[2]).setAge(Integer.parseInt(accounts[3])).
                setDescription(accounts[4].replace("_"," ")).
                setRegisterDate(LocalDateTime.parse(accounts[5], formatter)).
                setBirthDate(LocalDate.parse(accounts[6])).getAccount();

        return account;
    }
}
