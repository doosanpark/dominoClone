package unic.domino.pizza.clone.server.security.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import unic.domino.pizza.clone.server.security.vo.MemberVO;

public interface MemberService extends UserDetailsService {
    Integer save(MemberVO memberTO);
}