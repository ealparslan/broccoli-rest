package api.web;


import api.dto.*;
import api.model.Aggreement;
import api.model.BroccoliException;
import api.model.Dietician;
import api.model.ErrorResponse;
import api.service.ApiService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class ApiController {

    ApiService apiService;


    //region USER GET
    @GetMapping("/users")
    public List<UserDTO> getUsers() { return apiService.getUsers();}

    @GetMapping("/users/dieters-dieticians")
    public List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter() { return apiService.getUsersWithDieticianAndDieter();}
    //endregion

    @GetMapping("/dieters")
    public List<DieterDTO> getDieters() {
        return apiService.getDieters();
    }

    @GetMapping("/dieticians")
    public List<DieticianDTO> getDieticians() {
        return apiService.getDieticians();
    }

    @GetMapping("/aggreements/dieters-dieticians")
    public List<AggreementWithDieterAndDieticianDTO> getAggreementsWithDietersAndDieticians(@RequestParam(required = false) Integer dieticianId){
        if( null == dieticianId )
            return apiService.getAgreementsWithDietersAndDieticians();
        else
            return apiService.getAgreementsWithDietersAndDieticians(dieticianId);
    }

    //region POST OPERATIONS
    @PostMapping("/aggreements")
    public ResponseEntity<?> saveAggreement(@Valid @RequestBody AggreementCreateDTO aggreementCreateDTO) throws BroccoliException, URISyntaxException {
        AggreementWithDieterAndDieticianDTO aggreementWithDieterAndDieticianDTO = apiService.saveAggreement(aggreementCreateDTO);
        return ResponseEntity.created(new URI("/aggreements/dieters-dieticians/"+ aggreementWithDieterAndDieticianDTO.getDieticianId())).build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserCreateDTO userCreateDTO) throws BroccoliException, URISyntaxException {
        UserDTO userDTO = apiService.saveUser(userCreateDTO);
        return ResponseEntity.created(new URI("/users/"+ userDTO.getUsername())).build();
    }
    //endregion

    @ExceptionHandler(BroccoliException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(BroccoliException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, ex.getErrorCode());
    }
}
