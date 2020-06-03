package com.servis.broker.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.servis.broker.utils.Constants;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Autorizacija extends BasicAuthenticationFilter {
    private MyUserDetailService userDetailService;

    public Autorizacija(AuthenticationManager authenticationManager, MyUserDetailService userDetailService) {
        super(authenticationManager);
        this.userDetailService = userDetailService;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        String header = request.getHeader(Constants.HEADER_STRING);

        if (header == null || !header.startsWith(Constants.TOKEN_PREFIX)) {
            chain.doFilter(request, response); //prepustamo sledecem filteru
            return;
        }

        Authentication authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }
    //isparsira token i gleda sta se u njemu nalazi
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String tok = request.getHeader(Constants.HEADER_STRING);

        if (tok != null) {
            String korisnickoIme = JWT.require(Algorithm.HMAC256(Constants.SECRET_KEY.getBytes()))
                    .build()
                    //mora da ukloni bearer pa da verifikuje
                    .verify(tok.replace(Constants.TOKEN_PREFIX, ""))
                    .getSubject();

            if (korisnickoIme == null) {
                return null;
            }

            UserDetails userDetails = userDetailService.loadUserByUsername(korisnickoIme);
            UsernamePasswordAuthenticationToken forTheUser =
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
            return forTheUser;
        }
        return null;
    }

    /*public Autorizacija(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }*/
}
