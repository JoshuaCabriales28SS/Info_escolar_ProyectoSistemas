package mx.uam.repository;

import mx.uam.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
