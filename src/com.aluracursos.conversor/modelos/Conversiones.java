package com.aluracursos.conversor.modelos;

import com.aluracursos.conversor.api.CadenaApi;

import java.io.IOException;
import java.util.Scanner;

public class Conversiones {

    public static void main(String[] args) {
        //Asigno la url y dependiento de la opción que escoja el usuario se consulta el API
        String BASE_URL = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/";

        //Creo una instancia de la conexión
        CadenaApi cadenaApi = new CadenaApi(BASE_URL);
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        while (opcion != 7) {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion(cadenaApi, "USD", "ARS", teclado);
                    break;
                case 2:
                    realizarConversion(cadenaApi, "ARS", "USD", teclado);
                    break;
                case 3:
                    realizarConversion(cadenaApi, "USD", "BRL", teclado);
                    break;
                case 4:
                    realizarConversion(cadenaApi, "BRL", "USD", teclado);
                    break;
                case 5:
                    realizarConversion(cadenaApi, "USD", "COP", teclado);
                    break;
                case 6:
                    realizarConversion(cadenaApi, "COP", "USD", teclado);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("¡Error: Ingresa una opción válida!");
                    break;
            }
        }
        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("""
                
                
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ***************************************************
                """);
    }

    private static void realizarConversion(CadenaApi cadenaApi, String monedaBase, String monedaDestino, Scanner teclado) {
        System.out.print("Ingrese el valor que deseas convertir: ");
        double cantidad = teclado.nextDouble();

        try {
            DataMonedas conversion = cadenaApi.obtenerConversion(monedaBase, monedaDestino, cantidad);
            System.out.println("El valor " + cantidad + " [" + monedaBase + "] corresponde al valor final de =>>> " + conversion.getResultado() + " [" + monedaDestino + "]");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error al realizar la conversión :( !..");
        }
    }
}
