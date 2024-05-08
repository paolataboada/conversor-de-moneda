import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversor {
    public double convierteMoneda(String monedaActual, String monedaDeCambio, double montoAConvertir) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/405949ab5006e97170f48d7c/latest/" + monedaActual);
        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda dataMoneda = gson.fromJson(response.body(), Moneda.class);

            if (dataMoneda.conversion_rates().containsKey(monedaDeCambio)) {
                double tipoDeCambio = dataMoneda.conversion_rates().get(monedaDeCambio);
                return tipoDeCambio * montoAConvertir;
            }

            return 0;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
