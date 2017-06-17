package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

/**
 * Created by deniz on 6/17/17.
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Payment implements Serializable {
    static final long serialVersionUID = 914305839324989957L;

    @Id
    @GeneratedValue
    int id;

    String channel;
    Date date;
    float amountPaid; // TODO Use currency if applicable

    @ManyToOne
    Aggreement aggreement;

}
