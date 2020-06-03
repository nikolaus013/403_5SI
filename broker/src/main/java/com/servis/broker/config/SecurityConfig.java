package com.servis.broker.config;

import com.servis.broker.security.Autentikacija;
import com.servis.broker.security.Autorizacija;
import com.servis.broker.security.MyUserDetailService;
import com.servis.broker.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MyUserDetailService userDetailService;

    @Autowired
    public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, MyUserDetailService userDetailService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //iskljucujemo restrikcije za klijente koji dolaze sa drugih ip adresa
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(Constants.USER).permitAll() //mogu svi da pristupe userima
                .antMatchers(HttpMethod.POST, Constants.PROVIDER).permitAll() //provajder mora da se uloguje
                .anyRequest().authenticated()
                .and()
                .addFilter(new Autentikacija(authenticationManager()))
                .addFilter(new Autorizacija(authenticationManager(), userDetailService))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //gasimo sesije jer se radi preko tokena
    }
}
