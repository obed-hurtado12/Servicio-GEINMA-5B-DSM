package mx.edu.utez.GEINMA.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsById(long id);
    boolean existsByEmail(String email);
    List<User> findAllByRoleId(long id);
}
