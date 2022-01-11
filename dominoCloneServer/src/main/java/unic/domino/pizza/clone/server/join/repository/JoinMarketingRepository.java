package unic.domino.pizza.clone.server.join.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unic.domino.pizza.clone.server.join.entity.UserMarketing;

@Repository
public interface JoinMarketingRepository extends JpaRepository<UserMarketing, Integer>  {

}
