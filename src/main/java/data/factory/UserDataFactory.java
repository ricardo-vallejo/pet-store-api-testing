package data.factory;

import com.github.javafaker.Faker;
import model.User;

import static builder.UserRequestBuilder.createUser;

public class UserDataFactory {

    private static final Faker FAKER = new Faker();

    public static User validUser(){
        return createUser()
                .withId(FAKER.number().randomNumber())
                .withUserName(FAKER.name().username())
                .withFirstName(FAKER.name().firstName())
                .withLastName(FAKER.name().lastName())
                .withEmail(FAKER.internet().emailAddress())
                .withPassword(FAKER.internet().password())
                .withPhone(FAKER.phoneNumber().phoneNumber())
                .withUserStatus(0)
                .build();
    }

    public static User nullInformation(){
        return createUser()
                .withId(null)
                .withUserName(null)
                .withFirstName(null)
                .withLastName(null)
                .withEmail(null)
                .withPassword(null)
                .withPhone(null)
                .withUserStatus(null)
                .build();
    }

}
