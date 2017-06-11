package api.service;

import api.dto.*;
import api.model.*;
import api.repository.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Transactional
public class ApiServiceImpl implements ApiService {

    DieterRepository dieterRepository;
    DieticianRepository dieticianRepository;
    AggreementRepository aggreementRepository;


    @Override
    public List<DieterDTO> getDieters() {
        return dieterRepository.findAll().stream().map(DieterDTO::new).collect(toList());
    }

    @Override
    public List<DieticianDTO> getDieticians() {
        return dieticianRepository.findAll().stream().map(DieticianDTO::new).collect(toList());
    }

    @Override
    public List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians() {
        return aggreementRepository.findAll().stream().map(AggreementWithDieterAndDieticianDTO::new).collect(toList());
    }

    @Override
    public List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians(int dieticianId) {
        return aggreementRepository.findByPkDieticianId(dieticianId).stream().map(AggreementWithDieterAndDieticianDTO::new).collect(toList());
    }


    @Override
    public AggreementWithDieterAndDieticianDTO saveAggreement(AggreementCreateDTO aggreementCreateDTO) {
        Dieter dieter = dieterRepository.findOne(aggreementCreateDTO.getDieterId());
        if (dieter == null){
            return null;
        }
        Dietician dietician = dieticianRepository.findOne(aggreementCreateDTO.getDieticianId());
        if(dietician == null){
            return null;
        }


        AggreementPK pk = new AggreementPK();
        pk.setDieter(dieter);
        pk.setDietician(dietician);
        pk.setOfferDate(aggreementCreateDTO.getOfferDate());
        if(aggreementRepository.findOne(pk) != null){
            return null;
        }
        Aggreement aggreement = new Aggreement();
        aggreement.setPk(pk);
        aggreement.setApprovedDate(aggreementCreateDTO.getApprovedDate());
        aggreement.setPayAmount(aggreementCreateDTO.getPayAmount());
        aggreement.setPayPeriod(aggreementCreateDTO.getPayPeriod());
        aggreement.setStatus(aggreementCreateDTO.getStatus());

        return new AggreementWithDieterAndDieticianDTO(aggreementRepository.save(aggreement));
    }

}
