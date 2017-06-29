package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by deniz on 6/29/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Device  implements Serializable {
    static final long serialVersionUID = 249123846239784671L;

    @Id
    @GeneratedValue
    int id;

    String make;
    String model;
    long PNDI;
    Date addedOn;
    int status;

    @ManyToOne
    User user;


}
