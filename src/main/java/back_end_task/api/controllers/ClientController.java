package back_end_task.api.controllers;

import back_end_task.api.configuration.Mapper;
import back_end_task.api.dtos.ClientDTO;
import back_end_task.api.dtos.ClientDTOCreation;
import back_end_task.api.dtos.ClientDTOCreationWithPhone;
import back_end_task.api.dtos.EmailDTOCreation;
import back_end_task.api.service.ClientService;


import back_end_task.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api"
)
public class ClientController {


    private ClientService clientService;
    private Mapper mapper;


    @Autowired
    public ClientController(ClientService clientService, Mapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ClientDTO>> showAll() {
        List<ClientDTO> clientDTOs =  clientService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(clientDTOs, HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<ClientDTOCreation> addClient(@RequestBody ClientDTOCreation clientDTO) {

        try {
            clientService.createClient(mapper.toClient(clientDTO));
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Сделай так {\n" +
                    "  \"firstName\": \"string\",\n" +
                    "  \"lastName\": \"string\"\n" +
                    "}");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/addClient/withPhoneNumber")
    public ResponseEntity<ClientDTOCreationWithPhone> addClient(@RequestBody ClientDTOCreationWithPhone clientDTOCreationWithPhone) {

        try {
            clientService.createClient(mapper.toClientWithPhone(clientDTOCreationWithPhone));
            return new ResponseEntity<>(clientDTOCreationWithPhone,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/addClient/withEmail")
    public ResponseEntity<v> addClient(@RequestBody ClientDTOCreation clientDTOCreation) {

        try {
            clientService.createClient(mapper.toClientWithPhone(clientDTOCreationWithPhone));
            return new ResponseEntity<>(clientDTOCreationWithPhone,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
return null;
    }




}
