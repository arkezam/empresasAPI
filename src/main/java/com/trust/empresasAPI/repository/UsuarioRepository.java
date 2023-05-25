package com.trust.empresasAPI.repository;

import com.trust.empresasAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    UserDetails findByUsuarioname(String username);
}
