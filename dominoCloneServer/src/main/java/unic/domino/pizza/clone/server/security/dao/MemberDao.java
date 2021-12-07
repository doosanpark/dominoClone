package unic.domino.pizza.clone.server.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unic.domino.pizza.clone.server.security.entity.Member;

public interface MemberDao extends JpaRepository<Member, Integer> {
    Optional<Member> findByAccount(String account);
}