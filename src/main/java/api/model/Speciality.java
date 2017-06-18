package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by deniz on 6/18/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Speciality implements Serializable {
    static final long serialVersionUID = 2414623523247271L;

    @Id
    @GeneratedValue
    int id;
    @NotNull
    String title;
    String description;

    @OneToMany(mappedBy = "pk.speciality")
    List<DieticianSpeciality> dieticianSpecialities;

}
