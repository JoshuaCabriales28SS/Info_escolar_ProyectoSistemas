package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>{

}
