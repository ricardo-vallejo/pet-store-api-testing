package data.builder;

import com.github.javafaker.Faker;
import dk.brics.automaton.StringUnionOperations;
import model.User;
import org.apache.commons.lang3.StringUtils;

import static builder.UserRequestBuilder.createUser;

public class UserDataBuilder {

    private static final Faker FAKER = new Faker();

    private User user;

    private void userDefault() {
        user = new User();
        this.user = createUser()
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

    private UserDataBuilder(){
        userDefault();
    }

    public static UserDataBuilder userDataBuilder() {
        return new UserDataBuilder();
    }

    public UserDataBuilder withEmptyId() {
        this.user.setId(0L);
        return this;
    }

    public UserDataBuilder withEmptyUserName() {
        this.user.setUsername(StringUtils.EMPTY);
        return this;
    }

    public UserDataBuilder withEmptyFirstName() {
        this.user.setFirstName(StringUtils.EMPTY);
        return this;
    }

    public UserDataBuilder withEmptyLastName() {
        this.user.setLastName(StringUtils.EMPTY);
        return this;
    }

    public UserDataBuilder withEmptyEmail() {
        this.user.setEmail(StringUtils.EMPTY);
        return this;
    }

    public UserDataBuilder withEmptyPassword() {
        this.user.setPassword(StringUtils.EMPTY);
        return this;
    }

    public UserDataBuilder withEmptyPhone() {
        this.user.setPhone(StringUtils.EMPTY);
        return this;
    }

    public UserDataBuilder withEmptyUserStatus() {
        this.user.setUserStatus(0);
        return this;
    }
}
