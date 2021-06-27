package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
    private Integer id;
    private String login;

    private String password;
    private String firstName;

    public User(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Override
    public String toString() {

        return "User ID->" + id +
                ", login->" + login +
                ", password->" + password +
                ", firstName->" + firstName + "\n";
    }
}
