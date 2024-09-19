package back_end_task.api.controllers;


import back_end_task.api.configuration.EmailMapper;
import back_end_task.api.configuration.PhoneMapper;
import back_end_task.api.dtos.*;
import back_end_task.api.service.InformationService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/addContact/email")
    public ResponseEntity<HttpStatus> addContactEmail (@RequestBody EmailDTOCreation emailDTOCreation) {

        try {
            informationService.addContact(emailMapper.toEmail(emailDTOCreation));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/addContact/phone_number")
    public ResponseEntity<HttpStatus> addContactPhoneNumber (@RequestBody PhoneNumberDTOCreation phoneNumberDTOCreation) {

        try {
            informationService.addContact(phoneMapper.toPhoneNumber(phoneNumberDTOCreation));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/Emails/{id_client}")
    public  ResponseEntity<List<EmailDTO>> showAllEmails(@PathVariable Long id_client) {
        try {
            List<EmailDTO> listEmailDto =  informationService.getEmails(id_client).stream().map(emailMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(listEmailDto,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/phone_numbers/{id_client}")
    public  ResponseEntity<List<PhoneNumberDTO>> showAllPhoneNumbers(@PathVariable Long id_client) {
        try {
            List<PhoneNumberDTO> phoneNumberDTOS =  informationService.getPhonesNumbers(id_client).stream().map(phoneMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(phoneNumberDTOS,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }


    // some tests
    @GetMapping("/contacts/{id_client}")
    public  ResponseEntity<Object> showAllInformation(@PathVariable Long id_client) {
        try {
            List<Object> listEmailDto =  informationService.getEmails(id_client).stream().map(emailMapper::toDto).collect(Collectors.toList());
            List<Object> phoneNumberDTOS =  informationService.getPhonesNumbers(id_client).stream().map(phoneMapper::toDto).collect(Collectors.toList());
                listEmailDto.addAll(phoneNumberDTOS);
            return new ResponseEntity<>(listEmailDto,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }


}
