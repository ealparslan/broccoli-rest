package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by deniz on 6/18/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class DieticianSpeciality {

    @EmbeddedId
    DieticianSpecialityPK pk;
    Date approveDate;
    byte[] proof;
    boolean isApproved;
    float fee;




}
