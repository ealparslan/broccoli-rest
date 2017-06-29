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
public class Dietician implements Serializable {
    static final long serialVersionUID = -2414682343247271L;

    @Id
    @GeneratedValue
    int id;
    boolean isApproved;
    String intro;
    double rate;
    int bankAccountId;

    @OneToMany(mappedBy = "pk.dietician")
    List<Aggreement> aggreements;

    @OneToMany(mappedBy = "pk.dietician")
    List<DieticianSpeciality> dieticianSpecialities;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_account_id")
    BankAccount bankAccount;



}
