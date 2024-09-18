package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter



public class ClientDTOCreationWithPhone {

    private String firstName;
    private String lastName;
    private String phone;

    public ClientDTOCreationWithPhone(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
