import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        while (true) {
            System.out.println("***********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println();

            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println();

            System.out.println("***********************************************");
            System.out.println("Elija una opción válida:");

            Scanner lectura = new Scanner(System.in);
            int opcionElegida = Integer.parseInt(lectura.nextLine());
            ConsultaConversor consultaConversor = new ConsultaConversor();

            if (opcionElegida < 1 || opcionElegida > 7) {
                System.out.println("La opción no es válida.");
                break;
            }

            if (opcionElegida == 7) {
                System.out.println("Finalizando programa...");
                break;
            }

            try {
                var monedaActual = "";
                var monedaDeCambio = "";

                switch (opcionElegida) {
                    case 1:
                        monedaActual = "USD";
                        monedaDeCambio = "ARS";
                        break;
                    case 2:
                        monedaActual = "ARS";
                        monedaDeCambio = "USD";
                        break;
                    case 3:
                        monedaActual = "USD";
                        monedaDeCambio = "BRL";
                        break;
                    case 4:
                        monedaActual = "BRL";
                        monedaDeCambio = "USD";
                        break;
                    case 5:
                        monedaActual = "USD";
                        monedaDeCambio = "COP";
                        break;
                    case 6:
                        monedaActual = "COP";
                        monedaDeCambio = "USD";
                        break;
                    default:
                        break;
                }

                System.out.println("Ingrese el valor que desee convertir:");
                double montoAConvertir = Integer.parseInt(lectura.nextLine());
                double montoConvertido = consultaConversor.convierteMoneda(monedaActual, monedaDeCambio, montoAConvertir);
                System.out.println();
                System.out.println("El valor " + montoAConvertir + "[" + monedaActual + "] corresponde al valor final de =>>> " + montoConvertido + "[" + monedaDeCambio + "]");
                System.out.println();

                System.out.println("Presione Enter para realizar una nueva conversión...");
                var opcionContinuar = lectura.nextLine();
                if (!opcionContinuar.isEmpty()) {
                    System.out.println("Opción no válida. Finalizando programa...");
                    break;
                }
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }
}
