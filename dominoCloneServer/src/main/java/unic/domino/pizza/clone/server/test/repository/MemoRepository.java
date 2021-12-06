package unic.domino.pizza.clone.server.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unic.domino.pizza.clone.server.test.entity.Memo;

@Repository 
public interface MemoRepository extends JpaRepository<Memo, Long> { }

