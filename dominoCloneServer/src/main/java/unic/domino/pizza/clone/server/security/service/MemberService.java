package unic.domino.pizza.clone.server.security.service;


import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import unic.domino.pizza.clone.server.security.vo.MemberVO;

public interface MemberService extends UserDetailsService {
    Integer save(MemberVO memberTO);

    HashMap<String, Object> loadUserByUsername(String account, String password) throws UsernameNotFoundException;
}