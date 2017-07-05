package api.repository;

import api.model.Aggreement;
import api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by deniz on 6/14/17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);


}
