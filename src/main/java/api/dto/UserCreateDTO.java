package api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by deniz on 6/15/17.
 */

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateDTO {

    @NotNull
    int id;
    @NotEmpty
    String email;
    @NotEmpty
    char[] password;
    @NotEmpty
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
    String photo;
    Date signupOn;
    String language;
}
