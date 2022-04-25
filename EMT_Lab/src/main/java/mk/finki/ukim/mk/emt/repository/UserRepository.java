package mk.finki.ukim.mk.emt.repository;

import mk.finki.ukim.mk.emt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
