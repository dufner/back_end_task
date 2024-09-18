package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter



public class ClientDTOCreation {

    private String firstName;
    private String lastName;

    public ClientDTOCreation(Long id, String firstName, String lastName) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
