package back_end_task.api;//package task_manager.api;


import back_end_task.model.Client;
import back_end_task.model.Email;
import back_end_task.model.PhoneNumber;
import back_end_task.api.repositories.ClientRepository;
import back_end_task.api.repositories.EmailRepository;
import back_end_task.api.repositories.PhoneNumberRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoder {

    @Bean
    public CommandLineRunner dataLoader(
            ClientRepository clientRepository,
            EmailRepository emailRepository,
            PhoneNumberRepository phoneNumberRepository) {

        return args -> {
            for (int i = 0; i < 5; i++) {
                Faker faker = new Faker();
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();


                String emailST = String.format("%s.%s@testcode.ru", firstName, lastName);
                Client client = new Client(
                        firstName,
                        lastName
                );
                Email email= new Email(emailST);
                client.addemail(email);

                String phone_numberSt=faker.phoneNumber().phoneNumber();
                PhoneNumber phoneNumber= new PhoneNumber(phone_numberSt);


                client.addphonenumber(phoneNumber);


                clientRepository.save(client);

            }
        };
    }

}
