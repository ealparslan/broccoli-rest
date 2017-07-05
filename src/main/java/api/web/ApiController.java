package api.web;


import api.dto.*;
import api.exception.BroccoliException;
import api.exception.BroccoliNotFoundException;
import api.exception.ErrorResponse;
import api.service.ApiService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class ApiController {

    ApiService apiService;


    //region USER GET
    @GetMapping("/users")
    public List<UserDTO> getUsers() { return apiService.getUsers();}

    @GetMapping("/user/id/{userId}")
    public UserDTO getUser(@PathVariable int userId) throws BroccoliException {
        return apiService.getUser(userId);
    }

    @GetMapping("/user/{email}/")
    public UserDTO getUser(@PathVariable String email) throws BroccoliException {
        return apiService.getUser(email);
    }

    @GetMapping("/users-dieters-dieticians")
    public List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter() {
        return apiService.getUsersWithDieticianAndDieter();
    }

    @GetMapping("/user-dieters-dieticians/id/{userId}")
    public UserWithDieticianAndDieterDTO getUserWithDieticianAndDieter(@PathVariable int userId) throws BroccoliNotFoundException {
        return apiService.getUserWithDieticianAndDieter(userId);
    }
    //endregion

    @GetMapping("/dieters")
    public List<DieterDTO> getDieters() {
        return apiService.getDieters();
    }

    @GetMapping("/dieter/id/{dieterId}")
    public DieterDTO getDieter(@PathVariable int dieterId) throws BroccoliException {
        return apiService.getDieter(dieterId);
    }

    @GetMapping("/dieticians")
    public List<DieticianDTO> getDieticians() {
        return apiService.getDieticians();
    }

    @GetMapping("/dietician/id/{dieticianId}")
    public DieticianDTO getDietician(@PathVariable int dieticianId) throws BroccoliException {
        return apiService.getDietician(dieticianId);
    }

    @GetMapping("/aggreements-dieters-dieticians")
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
        return ResponseEntity.created(new URI("/aggreements-dieters-dieticians/dieticianId="+ aggreementWithDieterAndDieticianDTO.getDieticianId())).build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserCreateDTO userCreateDTO) throws BroccoliException, URISyntaxException {
        UserDTO userDTO = apiService.saveUser(userCreateDTO);
        return ResponseEntity.created(new URI("/user/"+ userDTO.getEmail()+"/")).build();
    }
    //endregion

    @ExceptionHandler(BroccoliException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(BroccoliException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, ex.getErrorCode());
    }
}
