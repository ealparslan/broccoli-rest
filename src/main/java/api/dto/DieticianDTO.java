package api.dto;

import api.model.Dietician;
import api.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DieticianDTO {

    int id;
    boolean isApproved;
    String intro;
    double rate;
    int user_id;
    // User user; user objesini de icinde vermek istersek burayi acmamiz yeterli zira ana dieter objesinde bu bilgi var. DTO ya gelirken kirpiyoruz


    public DieticianDTO(Dietician dietician){
        BeanUtils.copyProperties(dietician,this,"aggreement");
        user_id = dietician.getUser().getId();
    }
}
