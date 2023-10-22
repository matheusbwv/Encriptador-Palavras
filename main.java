import java.util.Arrays;
import java.util.Scanner;

public class main {

    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("---criptografia de palavrinhas---");
        System.out.println("---------------------------------");

        
        
        System.out.println(String.format("\u001b[1menter\u001b[0m para continuar"));
        scanner.nextLine();

        while (true) {
            String textoFinal = "";

            System.out.println("Escolha entre as duas opções");
            System.out.println("1 - Criptografar");
            System.out.println("2 - Descriptografar");
            System.out.println("3 - aperte se quiser desistir");
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 1 || escolha == 2) {
                String texto = scanner.nextLine().toUpperCase().replaceAll(" ", "");
                String chave = scanner.nextLine().toUpperCase();
                String chaveFinal = "";

                if (chave.length() > texto.length()) {
                    System.out.println("ta grande demais!!!! SOCORRO!!!!!");
                    break;
                } else {
                    for (int i = 0; i < texto.length(); i++) {
                        chaveFinal += chave.charAt(i % chave.length());
                    }

                    for (int i = 0; i < texto.length(); i++) {
                        if (texto.charAt(i) != ' ') {
                            int pLetraFrase = Arrays.binarySearch(alfabeto, texto.charAt(i));
                            int pLetraChave = Arrays.binarySearch(alfabeto, chaveFinal.charAt(i));

                            if (escolha == 1) {
                                textoFinal += alfabeto[(pLetraFrase + pLetraChave) % alfabeto.length];
                            } else if (escolha == 2) {
                                textoFinal += alfabeto[(pLetraFrase - pLetraChave + alfabeto.length) % alfabeto.length];
                            }
                        } else {
                            textoFinal += ' ';
                        }
                    }
                }

                System.out.println("seu resultado: " + textoFinal);
                System.out.println("aperte enter se quiser digitar mais palavras, ou então cancele com CTRL+ C");
                scanner.nextLine();
            } else {
                System.out.println("bye bye ");
                break;
            }
        }
    }
}