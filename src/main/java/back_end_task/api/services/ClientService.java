package back_end_task.api.services;

import back_end_task.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client Client);
    List<Client> findAll();
    Client findById(Long id);
}
