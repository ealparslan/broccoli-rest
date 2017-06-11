package api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AggreementCreateDTO {

    @NotNull
    Date offerDate;
    @NotNull
    int dieticianId;
    @NotNull
    int dieterId;
    Date approvedDate;
    String payPeriod;
    double payAmount;
    int status;

}
