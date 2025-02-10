package com.sell_buy.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sell_buy.api.service.MemberService;
import com.sell_buy.db.entity.Member;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfigure {

    private final MemberService memberService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                                .maximumSessions(1).expiredUrl("/login"))
                .sessionManagement(session ->
                        session.sessionFixation().newSession())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin.loginPage("/login").permitAll()
                                .usernameParameter("loginId")
                                .passwordParameter("password"))
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .addLogoutHandler((request, response, authentication) -> {
                                    response.setStatus(200);
                                }))
        ;

        return http.build();
    }

    private AuthenticationSuccessHandler jsonAuthenticationSuccessHandler() {
        return (request, response, authentication) -> {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(3600);

            String loginId = authentication.getName();
            Member member = memberService.getMemberByLoginId(loginId);

            if (member != null) {
                session.setAttribute("memId", member.getMemId());
                session.setAttribute("nickname", member.getNickname());
            }

            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"message\": \"Login successful\", \"status\": \"success\"}");
        };
    }

    private AuthenticationFailureHandler jsonAuthenticationFailureHandler() {
        return (request, response, exception) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("status", "error");
            responseData.put("message", "Login failed.");

            response.getWriter().write(new ObjectMapper().writeValueAsString(responseData));
        };
    }
}