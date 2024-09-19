package back_end_task.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class EmailDTO  {
    private String email;

    public EmailDTO(String email) {
        this.email = email;
    }
}
