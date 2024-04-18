package pp_2_3_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp_2_3_1.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
