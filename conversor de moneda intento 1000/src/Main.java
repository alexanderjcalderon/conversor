import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Mostrar bienvenida con formato estilo banco
        printWelcomeMessage();

        // Crear el scanner para recibir entradas del usuario
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        // Bucle principal del menú
        while (true) {
            // Mostrar el menú de opciones
            printMenu();

            // Leer la opción seleccionada por el usuario
            option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            // Procesar según la opción seleccionada
            switch (option) {
                case 1:
                    handleConversion(scanner, "USD", "ARS");
                    break;
                case 2:
                    handleConversion(scanner, "ARS", "USD");
                    break;
                case 3:
                    handleConversion(scanner, "USD", "CLP");
                    break;
                case 4:
                    handleConversion(scanner, "CLP", "USD");
                    break;
                case 5:
                    handleConversion(scanner, "USD", "BRL");
                    break;
                case 6:
                    handleConversion(scanner, "BRL", "USD");
                    break;
                case 7:
                    System.out.println("\n¡Gracias por usar el conversor! ¡Hasta pronto!");
                    scanner.close();
                    return;  // Salir del programa
                default:
                    System.out.println("Elija una opción válida (1-7).");
            }
        }
    }

    // Método para mostrar el menú de opciones
    private static void printMenu() {
        System.out.println("\n********************************************************");
        System.out.println("              MENÚ DE CONVERSIÓN DE MONEDAS");
        System.out.println("********************************************************");
        System.out.println("1. Dólar (USD) a Peso Argentino (ARS)");
        System.out.println("2. Peso Argentino (ARS) a Dólar (USD)");
        System.out.println("3. Dólar (USD) a Peso Chileno (CLP)");
        System.out.println("4. Peso Chileno (CLP) a Dólar (USD)");
        System.out.println("5. Dólar (USD) a Real Brasileño (BRL)");
        System.out.println("6. Real Brasileño (BRL) a Dólar (USD)");
        System.out.println("7. Salir");
        System.out.print("Elija una opción (1-7): ");
    }

    // Método para mostrar la bienvenida con formato estilo banco
    private static void printWelcomeMessage() {
        System.out.println("********************************************************");
        System.out.println("  Sea bienvenido/a al Conversor de Moneda =) ");
        System.out.println("********************************************************");
    }

    // Método para manejar la conversión de monedas
    private static void handleConversion(Scanner scanner, String baseCurrency, String targetCurrency) {
        // Mensaje adicional: Ingresar el valor a convertir
        System.out.print("\nIngrese el valor que desee convertir de " + baseCurrency + " a " + targetCurrency + ": ");
        double amount = scanner.nextDouble();

        // Realizar la conversión
        double result = CurrencyConverter.convert(baseCurrency, targetCurrency, amount);

        if (result != -1) {
            // Mostrar el resultado de la conversión con formato de estilo banco
            printConversionResult(amount, baseCurrency, result, targetCurrency);
        }
    }

    // Método para mostrar la conversión con formato estilo banco
    private static void printConversionResult(double amount, String baseCurrency, double result, String targetCurrency) {
        System.out.println("\n********************************************************");
        System.out.println("              Resultado de la Conversión: ");
        System.out.println("********************************************************");
        System.out.printf("   %.2f %s equivale a %.2f %s\n", amount, baseCurrency, result, targetCurrency);
        System.out.println("********************************************************");
    }
}