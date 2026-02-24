import java.util.Scanner;

public class dupli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[3];
        String opcao = "";

        // O laço do-while garante que o programa rode até que "X" seja digitado
        do {
            System.out.println("\n=== MENU DE GERENCIAMENTO ===");
            System.out.println("1 - Cadastrar Nomes");
            System.out.println("2 - Alterar Nome");
            System.out.println("3 - Remover Nome");
            System.out.println("4 - Listar Nomes");
            System.out.println("X - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextLine().toUpperCase(); // Lê a opção e converte para maiúsculo

            switch (opcao) {
                case "1":
                    System.out.println("\n--- CADASTRO ---");
                    for (int i = 0; i < nomes.length; i++) {
                        System.out.print("Digite o nome para a posição " + i + ": ");
                        nomes[i] = sc.nextLine();
                    }
                    break;

                case "2":
                    System.out.print("\nDigite a posição (0-2) para alterar: ");
                    int posAlterar = sc.nextInt();
                    sc.nextLine(); // Limpar buffer
                    if (posAlterar >= 0 && posAlterar < nomes.length) {
                        System.out.print("Digite o novo nome: ");
                        nomes[posAlterar] = sc.nextLine();
                    } else {
                        System.out.println("Posição inválida!");
                    }
                    break;

                case "3":
                    System.out.print("\nDigite a posição (0-2) para remover: ");
                    int posRemover = sc.nextInt();
                    sc.nextLine(); // Limpar buffer
                    if (posRemover >= 0 && posRemover < nomes.length) {
                        for (int i = posRemover; i < nomes.length - 1; i++) {
                            nomes[i] = nomes[i + 1];
                        }
                        nomes[nomes.length - 1] = null;
                        System.out.println("Removido com sucesso.");
                    } else {
                        System.out.println("Posição inválida!");
                    }
                    break;

                case "4":
                    System.out.println("\n--- LISTA ATUAL ---");
                    listar(nomes);
                    break;

                case "X":
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (!opcao.equals("X"));

        sc.close();
    }

    public static void listar(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " - " + (array[i] == null ? "[Vazio]" : array[i]));
        }
    }

}
