package api.dto;

import api.model.Dieter;
import api.model.Dietician;
import api.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by deniz on 6/14/17.
 */

// TODO : bu sinif henuz olmadi. User objesinin icinde digerlerini getirmek isteyebiliriz

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserWithDieticianAndDieterDTO {

    int id;
    String email;
    char[] password;
    String fullName;
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
    DieticianDTO dietician;
    DieterDTO dieter;


    public UserWithDieticianAndDieterDTO(User user) {

//        id = user.getId();
//        username = user.getUsername();
//        password = user.getPassword();
//        firstName =user.getFirstName();
//        lastName = user.getLastName();
//        email = user.getEmail();
//        googleId = user.getEmail();


        BeanUtils.copyProperties(user, this);
//        dieter = new DieterDTO(user.getDieter());
//        dietician = new DieticianDTO(user.getDietician());

    }
}
