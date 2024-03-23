package TCC.Tcc.repository;

import TCC.Tcc.model.LogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogUserRepository extends JpaRepository<LogUser, Long> {
}