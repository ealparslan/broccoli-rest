package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class AggreementPK  implements Serializable {
    static final long serialVersionUID = -4348323264723152L;

    Date offerDate;
    @ManyToOne
    Dietician dietician;
    @ManyToOne
    Dieter dieter;
}
