package org.itstep.accountmanager.readers;

import com.thoughtworks.xstream.XStream;
import org.itstep.accountmanager.account.Account;
import org.itstep.accountmanager.account.AccountConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements Reader{

    private static final String FILE_XML = "accounts.xml";

    @Override
    public List<Account> readFromFile() throws IOException {
        List<Account> accounts2 = new ArrayList<>();
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[] { Account.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        var accounts = Files.readAllLines(Path.of(FILE_XML));

        for(String str: accounts){
            accounts2.add((Account) xstream.fromXML(str));
        }

        return accounts2;
    }
}
