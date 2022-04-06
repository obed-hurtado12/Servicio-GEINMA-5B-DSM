package mx.edu.utez.GEINMA.experience.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    boolean existsById(long id);
}
