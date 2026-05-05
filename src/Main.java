import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner scanner = new Scanner(System.in, "UTF-8");
        SistemaLogistica sistema = new SistemaLogistica();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE LOGÍSTICA - E-COMMERCE ║");
        System.out.println("╚══════════════════════════════════════╝");

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1. Cadastrar entregador");
            System.out.println("2. Listar entregadores");
            System.out.println("3. Listar entregadores disponíveis");
            System.out.println("4. Criar entrega");
            System.out.println("5. Listar entregas");
            System.out.println("6. Atribuir entrega a entregador");
            System.out.println("7. Atualizar status de entrega");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Nome do entregador: ");
                    String nome = scanner.nextLine();
                    System.out.println("Tipo de veiculo (moto / bicicleta / carro): ");
                    String tipo = scanner.nextLine();
                    sistema.cadastrarEntregador(nome, tipo);
                    break;

                case 2:
                    sistema.listarEntregadores();
                    break;

                case 3:
                    sistema.listarEntregadoresDisponiveis();
                    break;

                case 4:
                    System.out.println("Endereco de destino: ");
                    String endereco = scanner.nextLine();
                    System.out.println("Distancia em km: ");
                    double distancia;
                    try {
                        distancia = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    } catch (NumberFormatException e) {
                        System.out.println("Distancia invalida.");
                        break;
                    }
                    sistema.criarEntrega(endereco, distancia);
                    break;

                case 5:
                    sistema.listarEntregas();
                    break;

                case 6:
                    System.out.println("ID da entrega: ");
                    int idEntrega;
                    int idEntregador;
                    try {
                        idEntrega = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("ID do entregador: ");
                        idEntregador = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("ID invalido.");
                        break;
                    }
                    sistema.atribuirEntrega(idEntrega, idEntregador);
                    break;

                case 7:
                    System.out.println("ID da entrega: ");
                    int idAtt;
                    try {
                        idAtt = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("ID invalido.");
                        break;
                    }
                    System.out.println("Novo status (PENDENTE / EM_ROTA / ENTREGUE / CANCELADO): ");
                    String status = scanner.nextLine();
                    System.out.println("Observacao (deixe em branco se nao houver): ");
                    String obs = scanner.nextLine();
                    sistema.atualizarStatusEntrega(idAtt, status, obs);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Ate logo!");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }
}