package back_end_task.api.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter



public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;

    public ClientDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
