package com.trust.empresasAPI.service;

import com.trust.empresasAPI.dto.DatosRegistroEmpresa;
import com.trust.empresasAPI.model.Empresa;
import com.trust.empresasAPI.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa registrarEmpresa(DatosRegistroEmpresa datosRegistroEmpresa) {
        Empresa empresa = new Empresa(datosRegistroEmpresa);
        return empresaRepository.save(empresa);
    }


    public List<Empresa> obtenerUltimosRegistros() {
        List<Empresa> ultimosRegistros = empresaRepository.findTop3ByOrderByIdDesc();
        return  ultimosRegistros;
    }

}