package com.dawntechbd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = com.dawntechbd.repo.UserRepo.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler loggingAccessDeniedHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(
                        "/static/**",
                        "/css/**",
                        "/fonts/**",
                        "/images/**",
                        "/js/**",
                        "/upload/**",
                        "/vendors/**",
                        "/", "/login", "/job/home", "/signup", "/user/add", "/emp/add"
                ).permitAll()
                .antMatchers(
                        "/edu/add", "/edu/listById",
                        "/address",
                        "/app/add",
                        "/app/history", "/app/historyList",
                        "/app/training", "/app/trainingList",
                        "/skills/add", "/skills/list",
                        "/app/addEx", "/app/exList",
                        "/app/ref", "/app/refList",
                        "/ms/add", "/ms/list",
                        "/rn/add", "/rn/list",
                        "/bg/add", "/bg/list",
                        "/dr/add", "/dr/list",
                        "/lan/add", "/lan/listById"
                ).hasAnyRole("USER")
                .antMatchers(
                        "/app/listByComId", "/job/listById",
                        "/com/add", "/com/listById",
                        "/job/post", "/job/postList/{id}"
                ).hasAnyRole("EMPLOYER")
                .antMatchers(
                        "/emp/list", "/emp/del/{id}",
                        "/role/**",
                        "/ctr/add", "/ctr/list",
                        "/div/add", "/div/list",
                        "/dist/add", "/dist/list",
                        "/city/add", "/city/list",
                        "/app/list",
                        "/cat/add", "/cat/list",
                        "/job/add", "/job/list", "/job/postList"
                ).hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(loggingAccessDeniedHandler);
    }


}
