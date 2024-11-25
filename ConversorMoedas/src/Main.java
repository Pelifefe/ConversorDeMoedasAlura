import model.Facade;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {

        Facade facade = new Facade();
        int opc;
        double valor;

        try{
            do{
                System.out.println("Seja bem-vindo ao seu convertor de moedas!");
                System.out.println("=== Digite a opção desejada ===");
                System.out.println("""
                               [1] - Dólar -> Peso argentino
                               [2] - Peso argentino -> Dólar
                               [3] - Dólar -> Real brasileiro
                               [4] - Real brasileiro -> Dólar
                               [5] - Dólar -> Peso colombiano
                               [6] - Peso colombiano -> Dólar
                               [7] - Sair do sistema
                               """);
                System.out.println("<<");
                opc = scanner.nextInt();

                System.out.println("Informe o valor a ser convertido:");
                valor = scanner.nextDouble();

                if (opc >= 1 && opc < 7) {
                    facade.operacoes(opc, valor);
                } else if (opc == 7) {
                    System.out.println("Operações finalizadas");
                    scanner.close();
                    System.exit(0);
                } else {
                    System.out.println("Opção inválida, favor informar opções de 1 a 7");
                }
                scanner.nextLine();
            }while(true);
        }catch (Exception e){
            e.getMessage();
        }
    }
}