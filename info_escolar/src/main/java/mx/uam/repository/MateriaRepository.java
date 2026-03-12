package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
