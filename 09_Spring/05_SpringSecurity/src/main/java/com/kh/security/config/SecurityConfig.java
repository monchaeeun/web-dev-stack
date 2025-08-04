package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	//제어 메서드
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(csrf -> csrf.disable()) //웹 보안 토큰 설정(비활성화)
				.httpBasic(basic -> basic.disable()) // HTTP Basic 이증 방식 비활성화(JWT 토큰 방식 사용)
				.sessionManagement(session -> 
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 설정 -> STATELESS 무상태 방식으로 설정(서버에서 기억하지 않게)
				.authorizeHttpRequests(authorize -> 
					authorize
						.requestMatchers("/mypage").authenticated()
						.requestMatchers("/admin").hasRole("ADMIN")// role 컬럼이 ADMIN만 들어갈 수 있음(앞에 ROLE_ 은 자동으로 읽어줌)
						.anyRequest().permitAll()//어떤 요청이든 전부 수락
				)
				.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncorder(){
		return new BCryptPasswordEncoder();
	}
}
