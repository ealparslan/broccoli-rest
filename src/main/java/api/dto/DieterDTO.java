package api.dto;

import api.model.Dieter;
import api.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DieterDTO {

    int id;
    int user_id;
    // User user; user objesini de icinde vermek istersek burayi acmamiz yeterli zira ana dieter objesinde bu bilgi var. DTO ya gelirken kirpiyoruz

    public DieterDTO(Dieter dieter){
        BeanUtils.copyProperties(dieter, this, "aggreement");
        user_id = dieter.getUser().getId();
    }
}
