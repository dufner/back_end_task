package back_end_task.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter

@Entity(name = "Client")
@Table(name = "clients")
public class Client   {

    @Id
    @SequenceGenerator(
            name = "clients_sequence",
            sequenceName = "clients_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "clients_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @OneToMany
            (
                    mappedBy = "client",
                    orphanRemoval = true,
                    cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
                    fetch = FetchType.LAZY
            )
    private List<PhoneNumber> phone_numbers = new ArrayList<>();

    @OneToMany
            (
                    mappedBy = "client",
                    orphanRemoval = true,
                    cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
                    fetch = FetchType.LAZY
            )
    private List<Email> emails = new ArrayList<>();

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addemail(Email email) {
        if (!this.emails.contains(email))
            this.emails.add(email);
        email.setClient(this);
    }

    public void addphonenumber (PhoneNumber phoneNumber ) {
        if (!this.phone_numbers.contains(phoneNumber))
            this.phone_numbers.add(phoneNumber);
        phoneNumber.setClient(this);
    }


}
