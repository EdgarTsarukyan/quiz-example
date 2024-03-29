package com.example.quiz.config;

import com.example.quiz.security.CurrentUserDetailServiceImpl;
import com.example.quiz.security.JWTAuthenticationTokenFilter;
import com.example.quiz.security.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CurrentUserDetailServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users").authenticated()
                .antMatchers(HttpMethod.POST, "/users/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/users", "/quiz", "/quiz/question",
                        "/quiz/question/questionOption").hasAnyAuthority("TEACHER")
                .antMatchers(HttpMethod.DELETE, "/users/{id}").hasAnyAuthority("TEACHER")
                .antMatchers(HttpMethod.PUT, "/users/{id}").hasAnyAuthority("TEACHER", "STUDENT")
                .antMatchers(HttpMethod.GET, "/quiz/question", "/quiz/question/questionOption",
                        "/quiz/question/questionOption/Answer").hasAnyAuthority("TEACHER", "STUDENT")
                .antMatchers(HttpMethod.GET, "/users/{id}").hasAnyAuthority("TEACHER")
                .antMatchers(HttpMethod.POST, "/quiz/question/questionOption/Answer")
                .hasAnyAuthority("TEACHER", "STUDENT");
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        http.headers().cacheControl();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JWTAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JWTAuthenticationTokenFilter();
    }

}