package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by deniz on 6/14/17.
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User implements Serializable {
    static final long serialVersionUID = -2414682311211247271L;

    @Id
    @GeneratedValue
    int id;
    @Column(unique = true)
    String username;
    char[] password;
    String firstName;
    String lastName;
    String email;
    String googleId;
    String facebookId;
    String twitterId;
    String linkedidId;
    String address;
    int zipcode;
    String state;
    String country;
    String gender;
    Date birthDate;
    byte[] photo;
    Date signupOn;
    String language;

    @OneToMany(mappedBy = "sender,receiver") // TODO we have to find a solution for this
    List<Message> messages;

}
