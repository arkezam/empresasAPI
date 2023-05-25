package com.trust.empresasAPI.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.trust.empresasAPI.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256("SECTRETO!"); //esta llave sercreta deberia ponerse en las variables de entorno
           return JWT.create()
                    .withIssuer("Trust")
                   .withSubject(usuario.getUsuarioname())
                   .withClaim("id",usuario.getId())
                   .withExpiresAt(generarFechaExpiracion())

                    .sign(algorithm);

        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(20).toInstant(ZoneOffset.of("-05:00"));
    }
    public String getSubject(String token){
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("SECTRETO!");
             verifier = JWT.require(algorithm)
                    .withIssuer("Trust")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("verifier Invalido, Token ya no es valido");

        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("verifier Invalido");
        }
        return verifier.getSubject();
    }
}
