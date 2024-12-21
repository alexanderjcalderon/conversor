import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyAPI {

    private static final String API_KEY = "b016ec6672ebbb2b5fc23a96"; // Tu API Key
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Método que obtiene las tasas de cambio de una moneda base
    public static JsonObject getExchangeRates(String baseCurrency) {
        // Validación de moneda base (puedes agregar más monedas si lo deseas)
        if (!isValidCurrency(baseCurrency)) {
            System.out.println("Moneda base no válida.");
            return null;
        }

        // URL para hacer la solicitud a la API
        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

        // Crear cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            // Hacer la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta es exitosa
            if (response.statusCode() == 200) {
                // Analizar la respuesta JSON usando Gson
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

                // Verificar que la respuesta contenga "conversion_rates"
                if (jsonResponse.has("conversion_rates")) {
                    return jsonResponse.getAsJsonObject("conversion_rates");
                } else {
                    System.out.println("No se encontraron tasas de conversión.");
                    return null;
                }
            } else {
                System.out.println("Error al obtener los datos. Código de estado: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Validar si la moneda base es válida
    private static boolean isValidCurrency(String currency) {
        return currency.equals("USD") || currency.equals("ARS") || currency.equals("BOB") ||
                currency.equals("BRL") || currency.equals("CLP") || currency.equals("COP");
    }
}