package mx.uam.repository;

import mx.uam.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
