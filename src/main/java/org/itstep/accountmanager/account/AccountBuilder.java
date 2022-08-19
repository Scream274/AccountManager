package org.itstep.accountmanager.account;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountBuilder {
    private Account account = new Account();

    public AccountBuilder setLogin(String login) {
        account.setLogin(login);
        return this;
    }

    public AccountBuilder setEmail(String email) {
        account.setEmail(email);
        return this;
    }

    public AccountBuilder setPassword(String password) {
        account.setPassword(password);
        return this;
    }

    public AccountBuilder setRegisterDate(LocalDateTime date) {
        account.setRegisterDate(date);
        return this;
    }

    public AccountBuilder setAge(int age) {
        account.setAge(age);
        return this;
    }

    public AccountBuilder setDescription(String description) {
        account.setDescription(description);
        return this;
    }

    public AccountBuilder setBirthDate(LocalDate birthDate) {
        account.setBirthDate(birthDate);
        return this;
    }

    public Account getAccount(){
        return account;
    }

    public AccountBuilder reset(){
        account = new Account();
        return this;
    }
}
