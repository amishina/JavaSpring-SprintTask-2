package bitlab.techorda.springboot.Sprinttask2.repository;

import bitlab.techorda.springboot.Sprinttask2.Models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRequestRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandledEquals (boolean handled);
}
