package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Unidad;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Long> {

}
