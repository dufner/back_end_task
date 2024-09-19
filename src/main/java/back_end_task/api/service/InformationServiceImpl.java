package back_end_task.api.service;

import back_end_task.api.repositories.EmailRepository;
import back_end_task.api.repositories.PhoneNumberRepository;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {


    private EmailRepository emailRepository;
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public InformationServiceImpl(EmailRepository emailRepository, PhoneNumberRepository phoneNumberRepository) {
        this.emailRepository = emailRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }


    @Override
    public PhoneNumber addContact(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public Email addContact(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public List<Email> getEmails(Long id) {
        return emailRepository.findByClient_Id(id);
    }

    @Override
    public List<PhoneNumber> getPhonesNumbers(Long id) {
        return null;
    }
}

