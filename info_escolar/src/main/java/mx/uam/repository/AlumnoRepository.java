package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
