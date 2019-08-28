package ru.geekbrains.builder;

import java.time.LocalDate;

public class User {

    private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private LocalDate birthday;

    public User() {
    }

    public User(String firstName,  String middleName, String lastName, String city, LocalDate birthday) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.city = city;
        this.birthday = birthday;
    }

    public static class UserBuilder {
        private User user;

        public UserBuilder() {
            user = new User();
        }

        public UserBuilder withFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public UserBuilder withMiddleName(String middleName) {
            user.middleName = middleName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }
        public UserBuilder withCity(String city) {
            user.city = city;
            return this;
        }

        public UserBuilder withBirthday (LocalDate birthday) {
            user.birthday = birthday;
            return this;
        }

        public User build() {
            return user;
        }
    }

    public static void main(String[] args) {
       UserBuilder userBuilder = new UserBuilder();

       User user = userBuilder
               .withFirstName("Ivan")
               .withLastName("Serebrinnikov")
               .withCity("Moscow")
               .withBirthday(28.08.2000)
               .build();
    }
}
