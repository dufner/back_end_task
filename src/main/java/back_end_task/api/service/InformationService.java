package back_end_task.api.service;

import back_end_task.api.dtos.ClientDTOWithEmailsAndPhoneNumbers;
import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;

import java.util.List;

public interface InformationService {

    PhoneNumber addContact(PhoneNumber phoneNumber);
    Email addContact(Email email);

    List<Email> getEmails (Long id);

   List<PhoneNumber> getPhonesNumbers (Long id);

    //TODO implement more methods


}
