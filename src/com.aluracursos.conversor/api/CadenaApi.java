package com.aluracursos.conversor.api;

import com.google.gson.Gson;
import com.aluracursos.conversor.modelos.DataMonedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CadenaApi {

    //El valor de la variable ya no puede ser cambiado al asignarle el "private final"
    private final String BASE_URL;

    public CadenaApi(String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    public DataMonedas obtenerConversion(String baseCode, String targetCode, double cantidad) throws IOException, InterruptedException {
        String url = BASE_URL + baseCode + "/" + targetCode + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        //Crear una instancia del GSON y deserializar el JSON de mi clase "DataMonedas"
        Gson gson = new Gson();
        DataMonedas conversion = gson.fromJson(response.body(), DataMonedas.class);

        // Extraer la tasa de conversión y calcular el resultado.
        double tasaConversion = conversion.getTasaConversion();
        //Obtener el resultado multiplicando la cantidad ingresada por la tasa de conversión extraida del API.
        double resultado = cantidad * tasaConversion;
        conversion.setResultado(resultado);
        //Retornando la conversión
        return conversion;
    }
}
