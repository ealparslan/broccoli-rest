package api.service;

import api.dto.*;

import java.util.List;

public interface ApiService {

    List<UserDTO> getUsers();

    List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter();

    List<DieterDTO> getDieters();

    List<DieticianDTO> getDieticians();

    List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians();

    List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians(int dieticianId);

    AggreementWithDieterAndDieticianDTO saveAggreement(AggreementCreateDTO aggreementCreateDTO);

    UserDTO saveUser(UserCreateDTO userCreateDTO);

}
