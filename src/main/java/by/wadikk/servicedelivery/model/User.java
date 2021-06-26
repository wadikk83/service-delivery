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

    @Override
    public String toString() {

        return "User ID->"+id+
                ", login->" + login +
                ", password->" + password +
                ", firstName->" + firstName;
    }
}
