package api.dto;

import api.model.Dietician;
import api.model.DieticianSpeciality;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deniz on 7/14/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DieticianDetailedDTO {
    int id;
    boolean isApproved;
    String intro;
    double rate;
    List<Speciality> specialities = new ArrayList<>();
    User user;


    public DieticianDetailedDTO(Dietician dietician){
        BeanUtils.copyProperties(dietician,this,"aggreements");
        for (DieticianSpeciality dieticianSpeciality:dietician.getDieticianSpecialities()) {
            specialities.add(new Speciality(dieticianSpeciality.getPk().getSpeciality().getTitle(),dieticianSpeciality.getFee()));
        }
        this.user = new User(dietician.getUser().getFullName(),dietician.getUser().getCountry(),dietician.getUser().getPhoto(),dietician.getUser().getState());
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class Speciality{
        String title;
        float fee;

        public Speciality(String _title, float _fee){
            title = _title;
            fee = _fee;
        }

    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    class User{
        String fullName;
        String country;
        String state;
        byte[] photo;


        public User(String _fullName, String _country,byte[] _photo, String _state){
            fullName = _fullName;
            country = _country;
            photo = _photo;
            state = _state;
        }

    }
}
