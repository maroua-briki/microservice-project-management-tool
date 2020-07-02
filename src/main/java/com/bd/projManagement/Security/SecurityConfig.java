package com.bd.projManagement.Security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/projects/**").hasAuthority("USER")
                .antMatchers(HttpMethod.POST,"/projects/**").hasAuthority("USER")
                .antMatchers(HttpMethod.PUT,"/projects/**").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE,"/projects/**").hasAuthority("USER")

                .antMatchers(HttpMethod.GET,"/phases/**").hasAuthority("USER")
                .antMatchers(HttpMethod.POST,"/phases/**").hasAuthority("USER")
                .antMatchers(HttpMethod.PUT,"/phases/**").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE,"/phases/**").hasAuthority("USER")

                .antMatchers(HttpMethod.GET,"/events/**").hasAuthority("USER")
                .antMatchers(HttpMethod.POST,"/events/**").hasAuthority("USER")
                .antMatchers(HttpMethod.PUT,"/events/**").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE,"/events/**").hasAuthority("USER")



                .antMatchers(HttpMethod.GET,"/projects/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/projects/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/projects/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/projects/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET,"/phases/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/phases/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/phases/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/phases/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET,"/events/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/events/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/events/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/events/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
