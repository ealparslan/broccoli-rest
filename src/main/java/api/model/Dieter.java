package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Dieter implements Serializable{
    static final long serialVersionUID = -641468843761927271L;

    @Id
    @GeneratedValue
    int id;

    @OneToMany(mappedBy = "pk.dieter")
    List<Aggreement> aggreements;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

}
