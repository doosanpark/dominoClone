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
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * #### JPA 쿼리 수행 메소드 참고 ### 
     * And					findByEmailAndUserId(String email, String userId)		여러필드를 and 로 검색
     * Or					findByEmailOrUserId(String email, String userId)		여러필드를 or 로 검색
     * Between				findByCreatedAtBetween(Date fromDate, Date toDate)		필드의 두 값 사이에 있는 항목 검색
     * LessThan				findByAgeLessThan(int age)								작은 항목 검색
     * GreaterThanEqual		findByAgeGreaterThanEqual(int age)						크거나 같은 항목 검색
     * Like					findByNameLike(String name)								like 검색
     * IsNull				findByJobIsNull()										null 인 항목 검색
     * In					findByJob(String … jobs)								여러 값중에 하나인 항목 검색
     * Order By				findByEmailOrderByNameAsc(String email)					검색 결과를 정렬하여 전달
     * ...
     */
    
    //로그인 아이디 비번 확인
    @Override
    public UserDetails loadUserByUsername(String account, String password) throws UsernameNotFoundException {
        Optional<Member> memberEntityWrapper = memberDao.findByAccountAndPassword(account, password);		// and 쿼리
        Member memberEntity = memberEntityWrapper.orElse(null);
        String encodedPassword = passwordEncoder.encode(password);	//스프링 시큐리티 암호화 작업은 매번 랜덤키를 부여
        
        //저장된 암호 비교 로직
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();				
        if(encoder.matches("asdf", encodedPassword)) {	//비번과 입력한 비번과 스프링 시큐리티에 의해 랜덤키로 암호화된 비번 비교
        	System.out.println(true);
        } else {
        	System.out.println(false);
        }
        
        
        if(memberEntity == null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
            return new User(memberEntity.getAccount(), memberEntity.getPassword(), authorities);
        }
        
        return null;
    }
    
    //로그인 중복체크
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