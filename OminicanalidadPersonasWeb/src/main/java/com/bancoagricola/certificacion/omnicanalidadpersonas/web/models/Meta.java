package com.bancoagricola.certificacion.omnicanalidadpersonas.web.models;

import lombok.Getter;
import lombok.Setter;

public class Meta {

    @Setter
    @Getter
    private String nombreMeta;
    @Setter
    @Getter
    private String montoMeta;
    @Setter
    @Getter
    private String plazoMeta;
    @Setter
    @Getter
    private String diaRetencion;
    @Setter
    @Getter
    private String cuentaARelacionar;
    @Setter
    @Getter
    private String aporteRetiroMeta;

}
