package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deniz on 6/17/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Message implements Serializable {
    static final long serialVersionUID = 914305839324989957L;

    @Id
    @GeneratedValue
    int id;

    Date sentOn;
    int status;
    String content;
    int pushId;

    @ManyToOne
    User sender;
    @ManyToOne
    User receiver;

}
