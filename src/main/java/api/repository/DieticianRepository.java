package api.repository;

import api.model.Dietician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DieticianRepository extends JpaRepository<Dietician, Integer> {
}
