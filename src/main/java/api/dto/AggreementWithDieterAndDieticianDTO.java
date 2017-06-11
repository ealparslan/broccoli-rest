package api.dto;

import api.model.Aggreement;
import api.model.AggreementPK;
import api.model.Dieter;
import api.model.Dietician;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AggreementWithDieterAndDieticianDTO {

    int dieticianId;
    int dieterId;
    Date offerDate;
    Date approvedDate;
    String payPeriod;
    double payAmount;
    int status;
    DieterDTO dieter;
    DieticianDTO dietician;

    public AggreementWithDieterAndDieticianDTO(Aggreement aggreement){
        AggreementPK pk = aggreement.getPk();
        dieterId = pk.getDieter().getId();
        dieticianId = pk.getDietician().getId();
        offerDate = pk.getOfferDate();
        approvedDate = aggreement.getApprovedDate();
        payPeriod = aggreement.getPayPeriod();
        payAmount = aggreement.getPayAmount();
        status = aggreement.getStatus();
        dieter = new DieterDTO(pk.getDieter());
        dietician = new DieticianDTO(pk.getDietician());
    }
}
