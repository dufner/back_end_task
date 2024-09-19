package back_end_task.api.configuration;

import back_end_task.api.dtos.EmailDTO;
import back_end_task.api.dtos.EmailDTOCreation;
import back_end_task.model.Client;
import back_end_task.model.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {
    public Email toEmail(EmailDTOCreation emailDTOCreation) {
        Email email =new Email(emailDTOCreation.getEmail());
        email.setClient(new Client(emailDTOCreation.getIdClient()));
        return email ;
    }


    public EmailDTO toDto(Email email) {
        return  new EmailDTO(email.getInformation());
    }
}
