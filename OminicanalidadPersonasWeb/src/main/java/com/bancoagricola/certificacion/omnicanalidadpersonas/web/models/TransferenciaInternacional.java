package com.bancoagricola.certificacion.omnicanalidadpersonas.web.models;

public class TransferenciaInternacional {

    private String cuentaOrigen;
    private String nroCuenta;
    private String nombreBeneficiario;
    private String direccionBeneficiario;
    private String pais;
    private String tipoRed;
    private String codigoBan1;
    private String codigoBan2;
    private String moneda;
    private String monto;
    private String nivel1;
    private String nivel2;
    private String detalle;

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public String getMonto() {
        return monto;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public String getDireccionBeneficiario() {
        return direccionBeneficiario;
    }

    public String getPais() {
        return pais;
    }

    public String getTipoRed() {
        return tipoRed;
    }

    public String getCodigoBan1() {
        return codigoBan1;
    }

    public String getCodigoBan2() {
        return codigoBan2;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getNivel1() {
        return nivel1;
    }

    public String getNivel2() {
        return nivel2;
    }

    public String getDetalle() {
        return detalle;
    }

    }
