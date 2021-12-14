package builder;

import model.User;

public class UserRequestBuilder {

    private final User user;

    private UserRequestBuilder(){
        user = new User();
    }

    public static UserRequestBuilder createUser(){
        return new UserRequestBuilder();
    }

    public UserRequestBuilder withId(Long id){
        this.user.setId(id);
        return this;
    }

    public UserRequestBuilder withUserName(String userName){
        this.user.setUsername(userName);
        return this;
    }

    public UserRequestBuilder withFirstName(String firstName){
        this.user.setFirstName(firstName);
        return this;
    }

    public UserRequestBuilder withLastName(String lastName){
        this.user.setLastName(lastName);
        return this;
    }

    public UserRequestBuilder withEmail(String email){
        this.user.setEmail(email);
        return this;
    }

    public UserRequestBuilder withPassword(String password){
        this.user.setPassword(password);
        return this;
    }

    public UserRequestBuilder withPhone(String phone){
        this.user.setPhone(phone);
        return this;
    }

    public UserRequestBuilder withUserStatus(int userStatus){
        this.user.setUserStatus(userStatus);
        return this;
    }

    public User build(){
        return user;
    }
}
