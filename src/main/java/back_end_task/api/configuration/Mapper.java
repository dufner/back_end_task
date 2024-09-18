package back_end_task.api.configuration;

import back_end_task.api.dtos.*;

import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    public ClientDTO toDto(Client client) {
        Long id= client.getId();
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        return  new ClientDTO(id,firstName,lastName);
    }

    public Client toClient(ClientDTOCreation clientDTO) {
        return new Client(clientDTO.getFirstName(), clientDTO.getLastName());
    }

//    public Email toDto(EmailDTO client) {
//        Long id= client.getId();
//        String firstName = client.getFirstName();
//        String lastName = client.getLastName();
//        return  new ClientDTO(id,firstName,lastName);
//    }

//    public Email toEmail(EmailDTOCreation emailDTOCreation) {
//        return new Email(emailDTOCreation.getEmail());
//    }

    public Client toClientWithPhone(ClientDTOCreationWithPhone clientDTO) {
        Client client = new Client(clientDTO.getFirstName(), clientDTO.getLastName());
        PhoneNumber phoneNumber = new PhoneNumber(clientDTO.getPhone());
        client.setPhone_numbers(List.of(phoneNumber));
        return client;
    }
    public Client toClientWithEmail(ClientDTOCreationWithEmail clientDTO) {
        Client client = new Client(clientDTO.getFirstName(), clientDTO.getLastName());
        Email email = new Email(clientDTO.getEmail());
        client.setEmails(List.of(email));
        return client;
    }

}
