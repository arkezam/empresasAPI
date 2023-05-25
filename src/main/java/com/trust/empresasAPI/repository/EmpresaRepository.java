package com.trust.empresasAPI.repository;

import com.trust.empresasAPI.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findTop3ByOrderByIdDesc();
}
