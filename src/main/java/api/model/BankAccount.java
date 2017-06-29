package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deniz on 6/29/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BankAccount implements Serializable {
    static final long serialVersionUID = 2494623453227271L;

    @Id
    @GeneratedValue
    int id;
    @NotNull
    String bank;
    String routingNumber;
    @NotNull
    String accountNumber;

    Date addedOn;

}
