package api.dto;

import api.model.Dieter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DieterDTO {

    int id;
    int userId;

    public DieterDTO(Dieter dieter){
        BeanUtils.copyProperties(dieter, this, "aggreement");
    }
}
