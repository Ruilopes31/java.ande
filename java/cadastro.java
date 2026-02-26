import java.util.Scanner;

public class cadastro {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] produtos = new String[5];
        int[] estoque = new int[5];

        int qtd = 0; // controla quantos cadastros existem
        int opcao;

        while (true) {
            System.out.println("\n=== SISTEMA DE ESTOQUE -LOJA ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Pesquisar produto");
            System.out.println("4 - Alterar produto");
            System.out.println("5 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1: // CADASTRAR
                    if (qtd == produtos.length) {//VERIFICA SE A LISTA ESTÁ CHEIA
                        System.out.println("Erro, capacidade maxiam alcançada de 5 produtos.");
                        break;
                    }

                    System.out.print("nome do produto: ");
                    produtos[qtd] = sc.nextLine();

                    System.out.print("quantidade em estoque: ");
                    estoque[qtd] = sc.nextInt();
                    sc.nextLine();

                    qtd++;
                    System.out.println("Cadastrado com sucesso!");
                    break;

                case 2: // LISTAR
                    if (qtd == 0) {
                        System.out.println("estoque vazio.");
                        break;
                    }

                    System.out.println("\n--- LISTA DE PRODUTOS ---");
                    for (int i = 0; i < qtd; i++) {
                        // Exibe índice, nome e quantidade conforme pedido
                        System.out.println("Índice: " + i + " | Produto: " + produtos[i] + " | Qtd: " + estoque[i]);
                    }
                    break;

                case 3: // PESQUISAR
                    if (qtd == 0) {
                        System.out.println("estoque vazio.");
                        break;
                    }

                    System.out.print("Digite o nome do produto: ");
                    String busca = sc.nextLine();

                    int posBusca = -1;
                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(busca)) {
                            posBusca = i;
                            break;
                        }
                    }

                    if (posBusca == -1) {
                        System.out.println("produto não encontrado.");
                    } else {
                        System.out.println("Resultado: " + produtos[posBusca] + " - Estoque: " + estoque[posBusca]);
                    }
                    break;

                case 4: // ALTERAR
                    if (qtd == 0) {
                        System.out.println("produto nao encontrado.");
                        break;
                    }

                    System.out.print("Digite o nome do produto que quer alterar: ");
                    String nomeAlterar = sc.nextLine();

                    int posAlt = -1;
                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(nomeAlterar)) {
                            posAlt = i;
                            break;
                        }
                    }

                    if (posAlt == -1) {
                        System.out.println("produto não encontrado.");
                    } else {
                        System.out.print("Novo nome do produto: ");
                        String novoNome = sc.nextLine();

                        System.out.print("Nova qauntidade de estoque: ");
                        int novaIdade = sc.nextInt();
                        sc.nextLine();

                        produtos[posAlt] = novoNome;
                        estoque[posAlt] = novaIdade;

                        System.out.println("Alterado com sucesso!");
                    }
                    break;

                case 5: // REMOVER (DESLOCANDO)
                System.out.print("Digite o nome do produto para remover: ");
                String nomeRem = sc.nextLine();
                int posRem = -1;
                for (int i = 0; i < qtd; i++) {
                    if (produtos[i].equalsIgnoreCase(nomeRem)) {
                        posRem = i;
                        break;
                    }

                }
                if (posRem == -1) {
                    System.out.println("Produto não encontrado.");
                } else {
                    
                    for (int i = posRem; i < qtd - 1; i++) {
                        produtos[i] = produtos[i + 1];
                        estoque[i] = estoque[i + 1];
                    }
                    qtd--;
                    System.out.println("Produto removido com sucesso!");
                }
                break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}

