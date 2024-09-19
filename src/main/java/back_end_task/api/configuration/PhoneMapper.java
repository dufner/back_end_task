package back_end_task.api.configuration;

import back_end_task.api.dtos.EmailDTOCreation;
import back_end_task.api.dtos.PhoneNumberDTOCreation;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    public PhoneNumber toPhoneNumber(PhoneNumberDTOCreation phoneNumberDTOCreation) {
        return new PhoneNumber(phoneNumberDTOCreation.getPhone_number());
    }
}
