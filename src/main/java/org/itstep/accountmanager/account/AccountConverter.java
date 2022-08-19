package org.itstep.accountmanager.account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static Account stringToAccount(String input) {
        DateTimeFormatter formatter = Account.FORMATTER;
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

    public static Account jsonToAccount(String jsonString){
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy(HH:mm:ss)").create();
        return gson.fromJson(jsonString, Account.class);
    }

    public static Account xmlToAccount(String xml){
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[] { Account.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        return (Account) xstream.fromXML(xml);
    }

}
