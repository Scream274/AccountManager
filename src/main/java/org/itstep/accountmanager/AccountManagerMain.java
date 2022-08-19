package org.itstep.accountmanager;

import org.itstep.accountmanager.account.*;
import org.itstep.accountmanager.readers.XmlReader;

import java.io.IOException;
import java.time.LocalDate;

public class AccountManagerMain {
    public static void main(String[] args) throws IOException {

        Account account1;
        Account account2;
        Account account3;
        AccountBuilder ab = new AccountBuilder();

        account1 = ab.setLogin("MyLogin").
                setPassword("password1111").
                setEmail("mymail@gmail.com").
                setAge(32).setDescription("Some interesting description").
                getAccount();

        account2 = ab.reset().
                setLogin("TestLogin").
                setPassword("testPassword").
                setEmail("test@gmail.com").
                setAge(16).
                setBirthDate(LocalDate.of(2006,9,27)).
                getAccount();

        account3 = ab.reset().
                setLogin("Cucumber").
                setEmail("cucumber@gmail.com").
                getAccount();

        AccountManager.writeToTXT(account1, account2);
        AccountManager.writeToJSON(account1);
        AccountManager.writeToXML(account1, account2, account3);

        var accountsFromXML = AccountManager.readFromXML();
        var accountsFromTXT = AccountManager.readFromTXT();
        var accountsFromJSON = AccountManager.readFromJSON();

        System.out.println("From xml:");
        AccountManager.showAllAccounts(accountsFromXML);

        System.out.println("From txt:");
        AccountManager.showAllAccounts(accountsFromTXT);

        System.out.println("From json:");
        AccountManager.showAllAccounts(accountsFromJSON);
    }
}
