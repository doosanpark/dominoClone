package unic.domino.pizza.clone.server.security.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unic.domino.pizza.clone.server.security.dao.MemberDao;
import unic.domino.pizza.clone.server.security.entity.Member;
import unic.domino.pizza.clone.server.security.service.MemberService;
import unic.domino.pizza.clone.server.security.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Optional<Member> memberEntityWrapper = memberDao.findByAccount(account);
        Member memberEntity = memberEntityWrapper.orElse(null);

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        return new User(memberEntity.getAccount(), memberEntity.getPassword(), authorities);
    }

    @Transactional
    @Override
    public Integer save(MemberVO memberVO) {
        Member member = memberVO.toEntity();
        member.setLastAccessDt(LocalDateTime.now());
        member.setRegDt(LocalDateTime.now());

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberDao.save(member).getId();
    }
}