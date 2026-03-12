package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
    
}
