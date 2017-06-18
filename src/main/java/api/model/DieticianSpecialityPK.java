package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deniz on 6/18/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class DieticianSpecialityPK implements Serializable {
    static final long serialVersionUID = -4348345664723852L;

    Date submitDate;

    @ManyToOne
    Dietician dietician;
    @ManyToOne
    Speciality speciality;

}
