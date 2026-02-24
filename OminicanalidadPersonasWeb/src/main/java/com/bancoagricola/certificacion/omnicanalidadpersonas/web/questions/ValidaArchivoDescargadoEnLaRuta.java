package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.annotations.Step;

import java.io.File;

public class ValidaArchivoDescargadoEnLaRuta implements Question<Boolean> {
    private String path;

    public ValidaArchivoDescargadoEnLaRuta(String path) {
        this.path = path;
    }

    @Step("{0} 'valida que se muestre el archivo en la ruta indicada'")
    @Override
    public Boolean answeredBy(Actor actor) {
        File file = new File(path);
        return (file.exists() && !file.isDirectory());
    }

    public static ValidaArchivoDescargadoEnLaRuta enLaRuta(String path){
           return new ValidaArchivoDescargadoEnLaRuta(path);
    }
}
