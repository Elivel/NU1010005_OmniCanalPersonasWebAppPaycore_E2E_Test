package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;

import io.cucumber.datatable.DataTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransformacionALista {

    // Método genérico para convertir un DataTable a una lista de objetos de tipo T
    public static <T> List<T> convertirDataTableALista(DataTable dataTable, Class<T> clazz) {
        // Obtener las columnas del DataTable como un mapa de filas
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        return rows.stream().map(row -> {
            try {
                // Obtener el constructor de la clase T
                Constructor<T> constructor = clazz.getConstructor();
                T obj = constructor.newInstance(); // Crear una nueva instancia de T

                // Recorrer los campos de la clase y asignar los valores de las filas
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String value = entry.getValue();

                    // Buscar el campo correspondiente en la clase
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true); // Acceder al campo, aunque sea privado

                    // Asignar el valor al campo
                    if (field.getType() == int.class) {
                        field.setInt(obj, Integer.parseInt(value));
                    } else if (field.getType() == String.class) {
                        field.set(obj, value);
                    }
                    // Puedes añadir más tipos si es necesario, como boolean, double, etc.
                }
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }
}
