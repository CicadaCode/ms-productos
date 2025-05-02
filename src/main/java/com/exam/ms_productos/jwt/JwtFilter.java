package com.exam.ms_productos.jwt;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final String authValidateUrl;

    public JwtFilter(@Value("${jwt.auth-service-url}") String authValidateUrl) {
        this.authValidateUrl = authValidateUrl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException, java.io.IOException {
        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        String token = header.substring(7);
        RestTemplate rt = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(token);
        ResponseEntity<Void> resp = rt.postForEntity(authValidateUrl, entity, Void.class);
        if (resp.getStatusCode() != HttpStatus.OK) {
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        chain.doFilter(req, res);
    }
}