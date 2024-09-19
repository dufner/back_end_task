package back_end_task.api.service;

import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.api.repositories.ClientRepository;
import back_end_task.api.repositories.EmailRepository;
import back_end_task.api.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {


    private EmailRepository emailRepository;
    private PhoneNumberRepository phoneNumberRepository;

    private ClientRepository clientRepository;



    @Autowired

    public ClientServiceImpl(EmailRepository emailRepository, PhoneNumberRepository phoneNumberRepository, ClientRepository clientRepository) {
        this.emailRepository = emailRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
      Client client =clientRepository.findById(id).get();
        return client;
    }


}

