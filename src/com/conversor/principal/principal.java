package com.conversor.principal;

import com.conversor.modelos.Conversor;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        int menu = 0;
        while (menu != 7) {
            System.out.println("""
                    **************************************\

                     Bienvenidos al sistema de conversion de monedas, seleccione una opcion\

                     1 - Dolar -> Peso Argentino\

                     2 - Peso Argentino -> Dolar\

                     3 - Dolar -> Real brasileño\

                     4 - Real brasileño -> Dolar\

                     5 - Dolar -> Peso Colombiano\

                     6 - Peso Colombiano -> Dolar\

                     7 - Salir\

                    **************************************""");
            menu = lectura.nextInt();

            if (1 <= menu && menu <= 6) {
                System.out.println("Ingrese el monto a convertir:");
                var cant = lectura.nextInt();
                String dir = switch (menu) {
                    case 1 ->
                            "https://v6.exchangerate-api.com/v6/131a6bfcca70b040fea2e482/pair/" + "USD" + "/" + "ARS" + "/" + cant;
                    case 2 ->
                            "https://v6.exchangerate-api.com/v6/131a6bfcca70b040fea2e482/pair/" + "ARS" + "/" + "USD" + "/" + cant;
                    case 3 ->
                            "https://v6.exchangerate-api.com/v6/131a6bfcca70b040fea2e482/pair/" + "USD" + "/" + "BRL" + "/" + cant;
                    case 4 ->
                            "https://v6.exchangerate-api.com/v6/131a6bfcca70b040fea2e482/pair/" + "BRL" + "/" + "USD" + "/" + cant;
                    case 5 ->
                            "https://v6.exchangerate-api.com/v6/131a6bfcca70b040fea2e482/pair/" + "USD" + "/" + "COP" + "/" + cant;
                    case 6 ->
                            "https://v6.exchangerate-api.com/v6/131a6bfcca70b040fea2e482/pair/" + "COP" + "/" + "USD" + "/" + cant;
                    default -> "";
                };

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(dir))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                Gson gson = new Gson();
                Conversor conversor = gson.fromJson(json, Conversor.class);
                conversor.setMonto((cant));
                System.out.println(conversor);
            }else{
                    System.out.println("Muchas gracias por utilizar nuestro convertidor...");
            }
        }
    }
}