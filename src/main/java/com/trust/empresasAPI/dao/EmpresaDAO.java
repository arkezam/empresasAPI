package com.trust.empresasAPI.dao;

import com.trust.empresasAPI.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Empresa insertEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresas (ruc, razon_social, direccion, estado) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, empresa.getRuc(), empresa.getRazonSocial(), empresa.getDireccion(), empresa.getEstado());
        return empresa;
    }

    public void updateEmpresa(Empresa empresa) {
        String sql = "UPDATE empresas SET razon_social = ?, direccion = ?, estado = ? WHERE ruc = ?";
        jdbcTemplate.update(sql, empresa.getRazonSocial(), empresa.getDireccion(), empresa.getEstado(), empresa.getRuc());
    }

    public void deleteEmpresa(long id) {
        String sql = "DELETE FROM empresas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Empresa getEmpresaById(long id) {
        String sql = "SELECT * FROM empresas WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("id"));
            empresa.setRuc(rs.getLong("ruc"));
            empresa.setRazonSocial(rs.getString("razon_social"));
            empresa.setDireccion(rs.getString("direccion"));
            empresa.setEstado(rs.getBoolean("estado"));
            return empresa;
        }, id);
    }

}