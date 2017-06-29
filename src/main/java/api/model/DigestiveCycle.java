package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by deniz on 6/29/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class DigestiveCycle  implements Serializable {
    static final long serialVersionUID = 24429823489602271L;

    @Id
    @GeneratedValue
    int id;
    String breakfast;
    String lunch;
    String dinner;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dieter_id")
    Dieter dieter;
}
