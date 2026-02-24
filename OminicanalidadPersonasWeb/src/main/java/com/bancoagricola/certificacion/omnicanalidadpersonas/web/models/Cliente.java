package com.bancoagricola.certificacion.omnicanalidadpersonas.web.models;

import lombok.Getter;
import lombok.Setter;

public class Cliente {

    @Setter
    @Getter
    private String tipoIdentificacion;
    @Setter
    @Getter
    private String numeroIdentificacion;
    @Setter
    @Getter
    private String mensajeEsperado;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String usuario;
    @Setter
    @Getter
    private String tipoDocumento;
}
