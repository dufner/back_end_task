package back_end_task.api.service;

import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;

import java.util.List;

public interface ClientService {
    Client createClient(Client Client);
    List<Client> findAll();

    //TODO implement more methods


}
