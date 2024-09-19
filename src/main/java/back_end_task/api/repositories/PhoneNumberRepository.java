package back_end_task.api.repositories;

import back_end_task.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    @Query("select p from PhoneNumber p where p.client.id = ?1")
    List<PhoneNumber> findByClient_Id(Long id);

}