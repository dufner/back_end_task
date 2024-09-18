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

@Entity(name = "PhoneNumber")
@Table(name = "phone_numbers",
        uniqueConstraints = {
                @UniqueConstraint(name = "phone_number_unique", columnNames = "phone_number")}
)
public class PhoneNumber {
    public PhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    @Id
    @SequenceGenerator(
            name = "phone_number_sequence",
            sequenceName = "phone_number_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "phone_number_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phone_number;

    @ManyToOne
    @JoinColumn(
            name = "client_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "phone_numbers_client_fk"
            )
    )
    private Client client;

}
