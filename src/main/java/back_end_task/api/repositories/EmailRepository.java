package back_end_task.api.repositories;

import back_end_task.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    @Query("select e from Email e where e.client.id = ?1")
    List<Email> findByClient_Id(Long id);


}