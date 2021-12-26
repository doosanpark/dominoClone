package unic.domino.pizza.clone.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import unic.domino.pizza.clone.server.security.service.impl.MemberServiceImpl;

/**
 * 
 * 참고: https://bamdule.tistory.com/53
 *
 */

@Configuration // 해당 클래스를 Configuration으로 등록
@EnableWebSecurity // Spring Security를 활성화

// Controller에서 특정 페이지에 특정 권한이 있는 유저만 접근을 허용할 경우 @PreAuthorize 어노테이션을 사용하는데, 해당 어노테이션에 대한 설정을 활성화시키는 어노테이션(필수X\)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 로그인 요청 시, 입력된 유저 정보와 DB의 회원정보를 비교해 인증된 사용자인지 체크하는 로직 정의
	@Autowired
	private MemberServiceImpl memberService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // 비밀번호를 복호화/암호화하는 로직이 담긴 객체를 Bean으로 등록
	}

	// WebSecurity: FilterChainProxy를 생성하는 필터로써 다양한 필터 설정 적용
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
		// Spring Security에서 css, js 등은 인증 대상에서 제외
	}

	// HttpSecurity를 통해 HTTP 요청에 대한 보안을 설정
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http 요청에 대해서 모든 사용자가 /** 경로로 요청할 수 있지만, /member/** , /admin/** 경로는
		// 인증된 사용자만 요청이 가능
		http.authorizeRequests().antMatchers("/member/**").authenticated().antMatchers("/admin/**").authenticated()
				.antMatchers("/**").permitAll();

		// form Login 설정을 진행
		http.formLogin().loginPage("/login") // 커스텀 로그인 페이지 경로와 로그인 인증 경로를 등록
				.defaultSuccessUrl("/") // 로그인 인증을 성공하면 이동하는 페이지를 등록
				.permitAll();

		// 로그아웃 설정을 진행
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // logoutRequestMatcher(new AntPathRequestMatcher("path"))
				.logoutSuccessUrl("/login") // 로그아웃 성공 시 이동할 경로를 지정합니다.
				.invalidateHttpSession(true); // 로그아웃 성공 시 세션을 제거합니다.

		// 권한이 없는 사용자가 접근했을 경우 이동할 경로를 지정
		http.exceptionHandling().accessDeniedPage("/denied");
		
		//csrf 체크를 안해야 post 전송 가능
		http.csrf().disable();
		
		//csrf 토큰 부여
		//참고: https://zzang9ha.tistory.com/341
		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

	// AuthenticationManagerBuilder : AuthenticationManager를 생성.
	// AuthenticationManager는 사용자 인증을 담당
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
		// auth.userDetailsService(service)에
		// org.springframework.security.core.userdetails.UserDetailsService 인터페이스를 구현한 Service를 넘겨야함
	}

}