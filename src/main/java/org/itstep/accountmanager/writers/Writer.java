package org.itstep.accountmanager.writers;

import org.itstep.accountmanager.account.Account;

import java.io.IOException;

public interface Writer {
    void saveToFile(Account account) throws IOException;
}
