package org.itstep.accountmanager.account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

public class AccountConverter {

    public static String accountToJSON(Account account) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(account);
    }

    public static String accountToString(Account account) {
        return account.getLogin() + ' ' + account.getEmail() + ' ' + account.getPassword() +
                ' ' + account.getAge() + ' ' + account.getDescription().replace(" ", "_")
                + ' ' + account.getRegisterDate().format(Account.FORMATTER) + ' ' + account.getBirthDate();
    }

    public static String accountToXML(Account account){
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[] { Account.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        String xml = xstream.toXML(account);
        return xml.replace("\n","");
    }
}
