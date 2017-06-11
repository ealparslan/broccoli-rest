package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Aggreement implements Serializable {
    static final long serialVersionUID = 9143058317927989957L;

    @EmbeddedId
    AggreementPK pk;
    Date approvedDate;
    String payPeriod;
    double payAmount;
    int status;

}
