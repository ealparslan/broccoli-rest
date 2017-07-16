package api.service;

import api.dto.*;
import api.exception.BroccoliException;
import api.exception.BroccoliNotFoundException;

import java.util.List;

public interface ApiService {

    List<UserDTO> getUsers();

    UserDTO getUser(int userId) throws BroccoliException;

    UserDTO getUser(String userName) throws BroccoliException;

    List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter();

    UserWithDieticianAndDieterDTO getUserWithDieticianAndDieter(int userId) throws BroccoliNotFoundException;

    List<DieterDTO> getDieters();

    DieterDTO getDieter(int dieterId) throws BroccoliException;

    List<DieticianDTO> getDieticians();

    List<DieticianDetailedDTO> getDieticiansDetailed();

    DieticianDTO getDietician(int dieticianId) throws BroccoliException;

    List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians();

    List<AggreementWithDieterAndDieticianDTO> getAgreementsWithDietersAndDieticians(int dieticianId);

    AggreementWithDieterAndDieticianDTO saveAggreement(AggreementCreateDTO aggreementCreateDTO) throws BroccoliException;

    UserDTO saveUser(UserCreateDTO userCreateDTO) throws BroccoliException;

}
