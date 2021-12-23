package unic.domino.pizza.clone.server.join.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unic.domino.pizza.clone.server.join.entity.User;

import java.util.List;

@Repository
public interface JoinRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.id.userId = :#{#userId}")
    public User selectUser(String userId);
}
