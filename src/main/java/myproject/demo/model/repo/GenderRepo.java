package myproject.demo.model.repo;

import myproject.demo.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GenderRepo extends JpaRepository<Gender, Long> {
    Gender findById(long id);
}
