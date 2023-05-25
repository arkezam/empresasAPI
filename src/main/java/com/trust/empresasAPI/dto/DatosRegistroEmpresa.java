package com.trust.empresasAPI.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroEmpresa(
        @NotNull
        @Digits(integer = 11, fraction = 0, message = "El número de RUC debe tener 11 dígitos")
        Long ruc,
        @NotBlank
        String razonSocial,
        @NotBlank
        String direccion,
        @NotNull
        Boolean estado
) {
}
