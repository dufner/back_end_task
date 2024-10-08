package back_end_task.api.services;

import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;

import java.util.List;

public interface InformationService {
    PhoneNumber addContact(PhoneNumber phoneNumber);
    Email addContact(Email email);
    List<Email> getEmails (Long id);
    List<PhoneNumber> getPhonesNumbers (Long id);

}
