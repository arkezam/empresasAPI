package com.trust.empresasAPI.controller;

import com.trust.empresasAPI.dao.EmpresaDAO;
import com.trust.empresasAPI.dto.DatosEmpresa;
import com.trust.empresasAPI.dto.DatosRegistroEmpresa;
import com.trust.empresasAPI.model.Empresa;
import com.trust.empresasAPI.repository.EmpresaRepository;
import com.trust.empresasAPI.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaDAO empresaDAO; //en lugar de DAO se utilizó Respository, sin embargo su implementación tambien es funcional
    @Autowired
    EmpresaService empresaService;


    @PostMapping //Registro de empresa
    public ResponseEntity<DatosEmpresa> registrarEmpresa(@RequestBody @Valid DatosRegistroEmpresa datosRegistroEmpresa, UriComponentsBuilder uriComponentsBuilder){
        Empresa empresa = empresaService.registrarEmpresa(datosRegistroEmpresa);
        DatosEmpresa datosEmpresa = new DatosEmpresa(empresa.getId(), empresa.getRuc(), empresa.getRazonSocial(), empresa.getDireccion(), empresa.getEstado());
        URI uri = uriComponentsBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(datosEmpresa);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerEmpresa(@PathVariable Long id){
        Empresa empresa =empresaDAO.getEmpresaById(id);
        DatosEmpresa datosEmpresa = new DatosEmpresa(empresa.getId(), empresa.getRuc(), empresa.getRazonSocial(), empresa.getDireccion(), empresa.getEstado());
        return ResponseEntity.ok(datosEmpresa);
    }

    @GetMapping("/ultimos")
    public ResponseEntity<List<Empresa>> obtenerUltimosRegistros() {
        List<Empresa> ultimosRegistros = empresaService.obtenerUltimosRegistros();
        return ResponseEntity.ok(ultimosRegistros);
    }

}
