import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverterAPI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Currency Converter App");

        System.out.print("Base currency (like USD): ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Target currency (like INR): ");
        String targetCurrency = sc.next().toUpperCase();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        try {
            String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Something went wrong. Check currency code or connection.");
                return;
            }

            Scanner urlScanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (urlScanner.hasNext()) {
                response.append(urlScanner.nextLine());
            }
            urlScanner.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject rates = json.getJSONObject("rates");

            System.out.println("\nSome available currencies:");
            showSomeCurrencies(rates);

            if (rates.has(targetCurrency)) {
                double rate = rates.getDouble(targetCurrency);
                double result = rate * amount;
                System.out.println("Converted: " + result + " " + targetCurrency);
            } else {
                System.out.println("Currency not found in list.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    public static void showSomeCurrencies(JSONObject rates) {
        // showing only 10 popular currencies
        String[] popular = {"USD", "INR", "EUR", "JPY", "GBP", "AUD", "CAD", "CNY", "SGD", "NZD"};
        for (String code : popular) {
            if (rates.has(code)) {
                System.out.print(code + "  ");
            }
        }
        System.out.println("\n");
    }
}