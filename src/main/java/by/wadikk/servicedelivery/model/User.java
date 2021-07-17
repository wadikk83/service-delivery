package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor

public class User {
    private Integer id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    private String firstName;
    private String lastName;
    private String numberPhone;

    private String address;

    private List<Order> orderList;

    public User(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public User(String login, String password, String firstName, String lastName, String numberPhone, String address) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    @Override
    public String toString() {

        return "User ID->" + id +
                ", login->" + login +
                ", password->" + password +
                ", firstName->" + firstName + "\n";
    }
}
