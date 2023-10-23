package tbpapi.thebestprototypeapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tbpapi.thebestprototypeapi.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
