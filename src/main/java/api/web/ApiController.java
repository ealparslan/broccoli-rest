package api.web;


import api.dto.*;
import api.model.Dietician;
import api.service.ApiService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class ApiController {

    ApiService apiService;


    @GetMapping("/users")
    public List<UserDTO> getUsers() { return apiService.getUsers();}

    @GetMapping("/users-dieters-dieticians")
    public List<UserWithDieticianAndDieterDTO> getUsersWithDieticianAndDieter() { return apiService.getUsersWithDieticianAndDieter();}

    @GetMapping("/dieters")
    public List<DieterDTO> getDieters() {
        return apiService.getDieters();
    }

    @GetMapping("/dieticians")
    public List<DieticianDTO> getDieticians() {
        return apiService.getDieticians();
    }

    @GetMapping("/aggreements-dieters-dieticians")
    public List<AggreementWithDieterAndDieticianDTO> getAggreementsWithDietersAndDieticians(){
        return apiService.getAgreementsWithDietersAndDieticians();
    }

    @GetMapping("/all-aggreements-dieters-dieticians")
    public List<AggreementWithDieterAndDieticianDTO> getAggreementsWithDietersAndDieticians(@RequestParam int dieticianId){
        return apiService.getAgreementsWithDietersAndDieticians(dieticianId);
    }

    @PostMapping("/aggreements")
    public ResponseEntity<?> saveAggreement(@Validated @RequestBody AggreementCreateDTO aggreementCreateDTO) {
        return (apiService.saveAggreement(aggreementCreateDTO) != null ? ok() : badRequest()).build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@Validated @RequestBody UserCreateDTO userCreateDTO) {
        return (apiService.saveUser(userCreateDTO) != null ? ok() : badRequest()).build();
    }
}
