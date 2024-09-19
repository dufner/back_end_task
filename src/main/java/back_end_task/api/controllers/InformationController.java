package back_end_task.api.controllers;


import back_end_task.api.configuration.EmailMapper;
import back_end_task.api.configuration.PhoneMapper;
import back_end_task.api.dtos.*;
import back_end_task.api.service.ClientService;
import back_end_task.api.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api"
)
public class InformationController {


    private InformationService informationService;
    private EmailMapper emailMapper;
    private PhoneMapper phoneMapper;


    public InformationController(InformationService informationService, EmailMapper emailMapper, PhoneMapper phoneMapper) {
        this.informationService = informationService;
        this.emailMapper = emailMapper;
        this.phoneMapper = phoneMapper;
    }

    @PostMapping("/addContact")
    public ResponseEntity<HttpStatus> addContact (@RequestBody EmailDTOCreation emailDTOCreation ) {

        try {
            informationService.addContact(emailMapper.toEmail(emailDTOCreation));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }




}
