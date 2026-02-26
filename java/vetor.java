import java.util.Scanner;

public class vetor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[3];
        int[] notas = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("informe o nome " + i);
            nomes[i] = sc.nextLine();

            System.out.println("informe a nota " + i);
            notas[i] = sc.nextInt();
            
            // --- A CORREÇÃO ESTÁ AQUI ---
            sc.nextLine(); // Consome o "Enter" que sobrou no buffer
            // ----------------------------

            System.out.println("o nome " + nomes[i] + " - notas " + notas[i]);
        }

        System.out.println("\n--- Resultado Final ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("o nome " + nomes[i] + " - notas " + notas[i]);
        }
        sc.close();
    }
}