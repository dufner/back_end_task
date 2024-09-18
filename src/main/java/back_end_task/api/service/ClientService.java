package back_end_task.api.service;

import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;

import java.util.List;

public interface ClientService {
    Client createClient(Client Client);

    Client addContact(PhoneNumber phoneNumber);

    List<Client> findAll();

    List<Email> getInformation(Long id);
    //TODO implement more methods


//    Client getClientByEmail(String email);
//
//    boolean isClientEmailPresent(String email);
//
//    Client getClientById(Long ClientId);
//
//    void deleteClient(Long id);
}
