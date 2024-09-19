package back_end_task.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter

@Entity(name = "Email")
@Table(name = "emails",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email")}
)
public class Email {



    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "email_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String information;

    @ManyToOne
    @JoinColumn(
            name = "client_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "emails_client_fk"
            )
    )
    private Client client;

    public Email(String information) {
        this.information = information;
    }


}
