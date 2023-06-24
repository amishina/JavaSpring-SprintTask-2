package bitlab.techorda.springboot.Sprinttask2.repository;

import bitlab.techorda.springboot.Sprinttask2.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
