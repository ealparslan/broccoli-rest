package api.web;


import api.dto.*;
import api.exception.BroccoliException;
import api.exception.BroccoliNotFoundException;
import api.exception.ErrorResponse;
import api.service.ApiService;
import api.utils.storage.StorageFileNotFoundException;
import api.utils.storage.StorageService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping
public class ApiController {

    ApiService apiService;
    StorageService storageService;


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

    @CrossOrigin
    @GetMapping("/dieters")
    public List<DieterDTO> getDieters() {
        return apiService.getDieters();
    }

    @CrossOrigin
    @GetMapping("/dieter/id/{dieterId}")
    public DieterDTO getDieter(@PathVariable int dieterId) throws BroccoliException {
        return apiService.getDieter(dieterId);
    }

    @GetMapping("/dieticians")
    public List<DieticianDTO> getDieticians() {
        return apiService.getDieticians();
    }

    @GetMapping("/dieticiansdetailed")
    public List<DieticianDetailedDTO> getDieticiansDetailed() {
        return apiService.getDieticiansDetailed();
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

    // region storage service
/*    @GetMapping("/files")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(ApiController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }*/

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @PostMapping("/files")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws URISyntaxException {

        String extension = StringUtils.cleanPath(file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.')));
        String fileName = "user_" + java.util.UUID.randomUUID() + extension;
        storageService.store(file,fileName);
        return ResponseEntity.created(new URI("/files/"+ fileName)).build();

    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    //endregion

}
