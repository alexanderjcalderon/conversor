import com.google.gson.JsonObject;

public class CurrencyConverter {

    // Método para convertir la cantidad de la moneda base a la moneda deseada
    public static double convert(String baseCurrency, String targetCurrency, double amount) {
        // Obtener las tasas de conversión desde la API
        JsonObject rates = CurrencyAPI.getExchangeRates(baseCurrency);

        if (rates != null && rates.has(targetCurrency)) {
            double rate = rates.get(targetCurrency).getAsDouble();
            return amount * rate;
        } else {
            System.out.println("No se pudo obtener la tasa de conversión para " + targetCurrency);
            return -1;
        }
    }
}