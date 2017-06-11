package api.repository;

import api.model.Aggreement;
import api.model.AggreementPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AggreementRepository extends JpaRepository<Aggreement, AggreementPK> {

    List<Aggreement> findByPkDieticianId(int dieticianId);

}
