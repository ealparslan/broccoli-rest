package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Dietician implements Serializable {
    static final long serialVersionUID = -2414682343247271L;

    @Id
    @GeneratedValue
    int id;
    int userId;
    boolean isApproved;
    String intro;
    double rate;
    int bankAccountId;

    @OneToMany(mappedBy = "pk.dietician")
    List<Aggreement> aggreements;

}
