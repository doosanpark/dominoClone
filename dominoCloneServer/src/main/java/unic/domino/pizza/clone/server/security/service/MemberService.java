package unic.domino.pizza.clone.server.security.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import unic.domino.pizza.clone.server.security.vo.MemberVO;

public interface MemberService extends UserDetailsService {
    Integer save(MemberVO memberTO);

	UserDetails loadUserByUsername(String account, String password) throws UsernameNotFoundException;
}