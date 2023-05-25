package com.trust.empresasAPI.controller;

import com.trust.empresasAPI.dto.DatosAuthUsuario;
import com.trust.empresasAPI.dto.DatosJWTToken;
import com.trust.empresasAPI.dto.DatosUsuario;
import com.trust.empresasAPI.model.Usuario;
import com.trust.empresasAPI.repository.UsuarioRepository;
import com.trust.empresasAPI.security.AutenticacionService;
import com.trust.empresasAPI.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository; //eliminar

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAuthUsuario datosAuthUsuario){
        Authentication AuthToken = new UsernamePasswordAuthenticationToken(datosAuthUsuario.usuarioname(),datosAuthUsuario.clave());
        authenticationManager.authenticate(AuthToken);
        var usuarioAutenticado = authenticationManager.authenticate(AuthToken);
        var JWToken =  tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWToken));

    }
    @GetMapping
    public ResponseEntity listaUsuarios(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return ResponseEntity.ok(usuario);
    }


}
