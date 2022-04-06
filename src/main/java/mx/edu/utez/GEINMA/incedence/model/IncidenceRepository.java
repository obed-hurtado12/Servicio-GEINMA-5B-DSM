package mx.edu.utez.GEINMA.incedence.model;

import mx.edu.utez.GEINMA.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenceRepository extends JpaRepository<Incidence, Long> {
    boolean existsById(long id);
    List<Incidence> findAllByTechnicalId(long id);
    List<Incidence> findAllByStatusId(long id);
    List<Incidence> findAllByClientId(long id);
}
