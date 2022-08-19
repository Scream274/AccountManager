package org.itstep.accountmanager.writers;

import com.thoughtworks.xstream.XStream;
import org.itstep.accountmanager.account.Account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter implements Writer {

    private static final String FILE_XML = "accounts.xml";
    private static List<Account> accountList = new ArrayList<>();

    @Override
    public void saveToFile(Account account) throws IOException {
        accountList.add(account);
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[] { List.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        String xml = xstream.toXML(accountList);

        Files.writeString(Path.of(FILE_XML), xml);
    }

}
