package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{
    
}
