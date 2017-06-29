package api.service;

import api.dto.*;
import api.model.*;
import api.repository.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
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
    UserRepository userRepository;


    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(toList());
    }

    @Override
    public List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter() {
        return userRepository.findAll().stream().map(UserWithDieticianAndDieterDTO::new).collect(toList());
    }


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
    public AggreementWithDieterAndDieticianDTO saveAggreement(AggreementCreateDTO aggreementCreateDTO) throws BroccoliException {
        Dieter dieter = dieterRepository.findOne(aggreementCreateDTO.getDieterId());
        if (dieter == null){
            throw new BroccoliException("dieter cannot be null!", HttpStatus.PRECONDITION_FAILED);
        }
        Dietician dietician = dieticianRepository.findOne(aggreementCreateDTO.getDieticianId());
        if(dietician == null){
            throw new BroccoliException("dietician cannot be null!", HttpStatus.PRECONDITION_FAILED);
        }


        AggreementPK pk = new AggreementPK();
        pk.setDieter(dieter);
        pk.setDietician(dietician);
        pk.setOfferDate(aggreementCreateDTO.getOfferDate());
        if(aggreementRepository.findOne(pk) != null){
            throw new BroccoliException("Already have this aggreement!", HttpStatus.CONFLICT);
        }
        Aggreement aggreement = new Aggreement();
        aggreement.setPk(pk);
        aggreement.setApprovedDate(aggreementCreateDTO.getApprovedDate());
        aggreement.setPayAmount(aggreementCreateDTO.getPayAmount());
        aggreement.setPayPeriod(aggreementCreateDTO.getPayPeriod());
        aggreement.setStatus(aggreementCreateDTO.getStatus());

        AggreementWithDieterAndDieticianDTO dto = null;
        try {
            dto = new AggreementWithDieterAndDieticianDTO(aggreementRepository.save(aggreement));
        } catch (Exception e) {
            throw new BroccoliException("An error occured while insert!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return dto;
    }

    @Override
    public UserDTO saveUser(UserCreateDTO userCreateDTO) throws BroccoliException {
        if(userRepository.findByUsername(userCreateDTO.getUsername()).size() > 0){
            throw new BroccoliException("Already have this user!", HttpStatus.CONFLICT);
        }
        User user = new User();
        user.setAddress(userCreateDTO.getAddress());
        user.setBirthDate(userCreateDTO.getBirthDate());
        user.setCountry(userCreateDTO.getCountry());
        user.setEmail(userCreateDTO.getEmail());
        user.setGender(userCreateDTO.getGender());
        user.setFacebookId(userCreateDTO.getFacebookId());
        user.setGoogleId(userCreateDTO.getGoogleId());
        user.setLanguage(userCreateDTO.getLanguage());
        user.setLastName(userCreateDTO.getLastName());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setPassword(userCreateDTO.getPassword());
        user.setPhoto(userCreateDTO.getPhoto());
        user.setSignupOn(userCreateDTO.getSignupOn());
        user.setState(userCreateDTO.getState());
        user.setTwitterId(userCreateDTO.getTwitterId());
        user.setUsername(userCreateDTO.getUsername());
        user.setZipcode(userCreateDTO.getZipcode());

        UserDTO dto = null;
        try {
            dto = new UserDTO(userRepository.save(user));
        } catch (Exception e) {
            throw new BroccoliException("An error occured while insert!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return dto;

    }

}
