package back_end_task.api.configuration;

import back_end_task.api.dtos.EmailDTO;
import back_end_task.api.dtos.PhoneNumberDTO;
import back_end_task.api.dtos.PhoneNumberDTOCreation;
import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    public PhoneNumber toPhoneNumber(PhoneNumberDTOCreation PhoneNumberDTOCreation) {
        PhoneNumber phoneNumber =new PhoneNumber(PhoneNumberDTOCreation.getPhoneNumber());
        phoneNumber.setClient(new Client(PhoneNumberDTOCreation.getIdClient()));
        return phoneNumber;
    }

    public PhoneNumberDTO toDto(PhoneNumber phoneNumber) {
        return  new PhoneNumberDTO(phoneNumber.getPhone_number());
    }
}
