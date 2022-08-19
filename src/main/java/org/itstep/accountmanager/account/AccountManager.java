package org.itstep.accountmanager.account;

import org.itstep.accountmanager.readers.*;
import org.itstep.accountmanager.writers.*;

import java.io.IOException;
import java.util.List;

public class AccountManager {

    public static void writeToJSON(Account... accounts) throws IOException {
        for (Account account : accounts) {
            new JsonWriter().saveToFile(account);
        }
    }

    public static void writeToTXT(Account... accounts) throws IOException {
        for (Account account : accounts) {
            new TextWriter().saveToFile(account);
        }
    }

    public static void writeToXML(Account... accounts) throws IOException {
        for (Account account : accounts) {
            new XmlWriter().saveToFile(account);
        }
    }

    public static List<Account> readFromTXT() throws IOException {
        return new TextReader().readFromFile();
    }

    public static List<Account> readFromJSON() throws IOException {
        return new JsonReader().readFromFile();
    }

    public static List<Account> readFromXML() throws IOException {
        return new XmlReader().readFromFile();
    }

    public static void showOnlyAdult(List<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAge() >= 18) {
                System.out.println(account);
            }
        }
    }

    public static void showAllAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

