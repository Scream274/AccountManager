package org.itstep.accountmanager.account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Account {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy(HH:mm:ss)");

    private String login;
    private String email;
    private String password;
    private LocalDateTime registerDate = LocalDateTime.now();
    private int age;
    private String description = "no description";
    private LocalDate birthDate = LocalDate.EPOCH;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        birthDate = LocalDate.now().minusYears(age);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        age = LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {

        return "============================================\n" +
                "Login: " + login + "\nEmail: " + email + "\nPassword: " + password +
                "\nAge: " + age + " years old\nDescription: " + description +
                "\nDate of register: " + registerDate.format(FORMATTER) +
                "\nBirth date: " + birthDate +
                "\n============================================\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return age == account.age && Objects.equals(login, account.login) && Objects.equals(email, account.email) && Objects.equals(password, account.password) && Objects.equals(registerDate, account.registerDate) && Objects.equals(description, account.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password, registerDate, age, description);
    }
}
