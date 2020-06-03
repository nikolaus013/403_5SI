package com.servis.broker.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servis.broker.model.User;
import com.servis.broker.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Autentikacija extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authManager;

    @Autowired
    public Autentikacija(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User kredencijali = new ObjectMapper().readValue(request.getInputStream(), User.class); //request sadrzi sve sto korisnik unosi
            return authManager.authenticate(new UsernamePasswordAuthenticationToken(kredencijali.getUsername(), kredencijali.getPassword(), new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }

    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth)
        throws IOException, ServletException {
        //generse token i Authentication auth je rezultat od f-je attemptAuthentication
        String tok = JWT.create()
                .withSubject(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername())
                .withClaim("Tim", "SI")
                .withExpiresAt(new Date(System.currentTimeMillis() + Constants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(Constants.SECRET_KEY.getBytes()));

        response.addHeader(Constants.HEADER_STRING, Constants.TOKEN_PREFIX + tok);

    }
}
