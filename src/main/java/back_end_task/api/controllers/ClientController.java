package back_end_task.api.controllers;


import back_end_task.api.mappers.ClientMapper;
import back_end_task.api.dtos.*;

import back_end_task.api.services.ClientService;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api"
)
public class ClientController {


    private ClientService clientService;
    private ClientMapper clientMapper;


@Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/allClients")
    @ResponseBody
    public ResponseEntity<List<ClientDTO>> showAll() {
        List<ClientDTO> clientDTOs =  clientService.findAll().stream().map(clientMapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(clientDTOs, HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<ClientDTOCreation> addClient(@RequestBody ClientDTOCreation clientDTO) {

        try {
            clientService.createClient(clientMapper.toClient(clientDTO));
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/addClient/withPhoneNumber")
    public ResponseEntity<ClientDTOCreationWithPhone> addClient(@RequestBody ClientDTOCreationWithPhone clientDTOCreationWithPhone) {

        try {
            clientService.createClient(clientMapper.toClientWithPhone(clientDTOCreationWithPhone));
            return new ResponseEntity<>(clientDTOCreationWithPhone,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addClient/withEmail")
    public ResponseEntity<ClientDTOCreationWithEmail> addClient(@RequestBody ClientDTOCreationWithEmail clientDTOCreationWithEmail) {

        try {
            clientService.createClient(clientMapper.toClientWithEmail(clientDTOCreationWithEmail));
            return new ResponseEntity<>(clientDTOCreationWithEmail,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findByID/{id_client}")
    @ResponseBody
    public ResponseEntity<ClientDTO> findByID(@PathVariable Long id_client) {
        ClientDTO clientDTO = clientMapper.toDto(clientService.findById(id_client)) ;
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }


}
