package api.service;

import api.dto.*;
import api.model.BroccoliException;

import java.util.List;

public interface ApiService {

    List<UserDTO> getUsers();

    List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter();

    List<DieterDTO> getDieters();

    List<DieticianDTO> getDieticians();

    List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians();

    List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians(int dieticianId);

    AggreementWithDieterAndDieticianDTO saveAggreement(AggreementCreateDTO aggreementCreateDTO) throws BroccoliException;

    UserDTO saveUser(UserCreateDTO userCreateDTO) throws BroccoliException;

}
