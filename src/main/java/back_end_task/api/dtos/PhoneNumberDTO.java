package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class PhoneNumberDTO  {
    private String phoneNumber;

    public PhoneNumberDTO(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
