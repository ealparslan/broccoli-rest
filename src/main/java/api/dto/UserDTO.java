package api.dto;

import api.model.Dieter;
import api.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by deniz on 6/14/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class UserDTO {

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

    public UserDTO(User user){
        BeanUtils.copyProperties(user, this);
    }

}
