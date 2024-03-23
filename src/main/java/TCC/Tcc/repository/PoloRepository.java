package TCC.Tcc.repository;

import TCC.Tcc.model.Polo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoloRepository extends JpaRepository<Polo, Long> {
}

