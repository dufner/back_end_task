package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class PhoneNumberDTOCreation {
    private String phoneNumber;
    private Long idClient;
}
