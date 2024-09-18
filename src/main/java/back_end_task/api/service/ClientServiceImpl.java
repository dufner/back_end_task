package back_end_task.api.service;

import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;
import back_end_task.api.repositories.ClientRepository;
import back_end_task.api.repositories.EmailRepository;
import back_end_task.api.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private EmailRepository emailRepository;
    private PhoneNumberRepository phoneNumberRepository;


    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, EmailRepository emailRepository, PhoneNumberRepository phoneNumberRepository) {
        this.clientRepository = clientRepository;
        this.emailRepository = emailRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client addContact(PhoneNumber phoneNumber) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Email> getInformation(Long id) {
        return null;
    }


//    private static final String ADMIN="ADMIN";
//    private static final String USER="USER";
//
//    private UserRepository userRepository;
//    private TaskRepository taskRepository;
//    private RoleRepository roleRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    @Autowired
//    public ClientServiceImpl(UserRepository userRepository,
//                             TaskRepository taskRepository,
//                             RoleRepository roleRepository,
//                             BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.taskRepository = taskRepository;
//        this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    public User createUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Role userRole = roleRepository.findByRole(USER);
//        user.setRoles(new ArrayList<>(Collections.singletonList(userRole)));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User changeRoleToAdmin(User user) {
//        Role adminRole = roleRepository.findByRole(ADMIN);
//        user.setRoles(new ArrayList<>(Collections.singletonList(adminRole)));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public boolean isUserEmailPresent(String email) {
//        return userRepository.findByEmail(email) != null;
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        User user = userRepository.getOne(id);
//        user.getTasksOwned().forEach(task -> task.setOwner(null));
//        userRepository.delete(user);
//    }

}

