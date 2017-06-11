package api.repository;

import api.model.Dieter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DieterRepository extends JpaRepository<Dieter, Integer> {
}
