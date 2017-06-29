package api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by deniz on 6/29/17.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class SleepCycle   implements Serializable {
    static final long serialVersionUID = 242384241048502271L;

    @Id
    @GeneratedValue
    int id;

    String wakeUpWeekDays;
    String sleepWeekDays;
    String wakeUpWeekEnds;
    String sleepWeekEnds;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dieter_id")
    Dieter dieter;


}
