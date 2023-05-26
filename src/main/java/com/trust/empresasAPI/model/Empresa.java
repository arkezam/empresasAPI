package com.trust.empresasAPI.model;

import com.trust.empresasAPI.dto.DatosActualizarEmpresa;
import com.trust.empresasAPI.dto.DatosRegistroEmpresa;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column
    private String direccion;

    @Column
    private Boolean estado;


    public Empresa(DatosRegistroEmpresa datosRegistroEmpresa) {
        this.ruc = datosRegistroEmpresa.ruc();
        this.razonSocial = datosRegistroEmpresa.razonSocial();
        this.direccion = datosRegistroEmpresa.direccion();
        this.estado = true;
    }


    public Empresa() {

    }

    public void actualizarDatos(DatosActualizarEmpresa datosActualizarEmpresa) {
        this.razonSocial = datosActualizarEmpresa.razonSocial();
        this.direccion = datosActualizarEmpresa.direccion();
    }
}
