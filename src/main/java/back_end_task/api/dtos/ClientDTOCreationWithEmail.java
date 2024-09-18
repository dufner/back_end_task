package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter



public class ClientDTOCreationWithEmail {

    private String firstName;
    private String lastName;
    private String email;

    public ClientDTOCreationWithEmail(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
