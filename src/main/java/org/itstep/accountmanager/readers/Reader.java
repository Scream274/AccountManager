package org.itstep.accountmanager.readers;

import org.itstep.accountmanager.account.Account;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Account> readFromFile() throws IOException;
}
