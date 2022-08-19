package org.itstep.accountmanager.writers;

import com.thoughtworks.xstream.XStream;
import org.itstep.accountmanager.account.Account;
import org.itstep.accountmanager.account.AccountConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class XmlWriter implements Writer {

    private static final String FILE_XML = "accounts.xml";

    @Override
    public void saveToFile(Account account) throws IOException {
        String xml = AccountConverter.accountToXML(account);
        Files.writeString(Path.of(FILE_XML), xml + "\n", StandardOpenOption.APPEND);
    }

}
