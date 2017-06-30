package api.repository;

import api.dto.DieterDTO;
import api.model.Aggreement;
import api.model.Dieter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DieterRepository extends JpaRepository<Dieter, Integer> {

}
