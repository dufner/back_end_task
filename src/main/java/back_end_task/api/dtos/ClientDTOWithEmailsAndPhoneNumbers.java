package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter



public class ClientDTOWithEmailsAndPhoneNumbers {

    private Long id;
    private String firstName;
    private String lastName;

    public ClientDTOWithEmailsAndPhoneNumbers(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
