package mx.uam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uam.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{
    
}
