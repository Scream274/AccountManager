package org.itstep.accountmanager.readers;

import com.thoughtworks.xstream.XStream;
import org.itstep.accountmanager.account.Account;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlReader implements Reader{

    private static final String FILE_XML = "accounts.xml";

    @Override
    public List<Account> readFromFile() throws IOException {
        List<Account> accounts;
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[] { Account.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        accounts = (List<Account>) xstream.fromXML(new File(FILE_XML));

        return accounts;
    }
}
