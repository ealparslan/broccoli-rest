package api.dto;

import api.model.Dietician;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DieticianDTO {

    int id;
    int userId;
    boolean isApproved;
    String intro;
    double rate;
    int bankAccountId;

    public DieticianDTO(Dietician dietician){
        BeanUtils.copyProperties(dietician,this,"aggreement");
    }
}
