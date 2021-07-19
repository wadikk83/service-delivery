package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType (XmlAccessType.FIELD)
public class User {
    @XmlAttribute(name = "id")
    private Integer id;
    @NonNull
    @XmlElement(name = "login")
    private String login;
    @NonNull
    @XmlTransient
    private String password;
    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "numberPhone")
    private String numberPhone;
    @XmlElement(name = "address")
    private String address;

    //private List<Order> orderList;


    public User() {
    }

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
