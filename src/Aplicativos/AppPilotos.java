package Aplicativos;

import Classes.Piloto;
import Classes.Aeronave;
import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {
                
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                System.out.print("Nome: ");
                String nome = in.nextLine();
                System.out.print("CPF: ");
                String cpf = in.nextLine();
                System.out.print("Breve (código de licença do piloto): ");
                String breve = in.nextLine();

                try {
                    Piloto piloto = new Piloto(nome, cpf, breve);
                    pilotos[qtdCadastrados++] = piloto;
                    System.out.println("\nPiloto cadastrado com sucesso.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nErro ao cadastrar piloto: " + e.getMessage());
                }

                voltarMenu(in);
            } else if (opcao == 2) {

                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("\nLista de Pilotos:");
                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println(pilotos[i]);
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                
                System.out.print("Digite o CPF do piloto: ");
                String cpfBusca = in.nextLine();
                Piloto pilotoEncontrado = null;

                for (int i = 0; i < qtdCadastrados; i++) {
                    if (pilotos[i].getCpf().equals(cpfBusca)) {
                        pilotoEncontrado = pilotos[i];
                        break;
                    }
                }

                if (pilotoEncontrado != null) {
                    System.out.println("\nPiloto encontrado:\n" + pilotoEncontrado);
                } else {
                    System.out.println("\nPiloto não encontrado.");
                }

                voltarMenu(in);
            } else if (opcao == 4) {
                
                if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("\nPilotos disponíveis:");
                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println((i + 1) + " - " + pilotos[i].getNome());
                }
                System.out.print("Escolha um piloto pelo número: ");
                int indicePiloto = in.nextInt();
                in.nextLine();

                if (indicePiloto < 1 || indicePiloto > qtdCadastrados) {
                    System.out.println("\nOpção inválida.");
                    voltarMenu(in);
                    continue;
                }

                Piloto pilotoSelecionado = pilotos[indicePiloto - 1];

                System.out.print("Modelo da aeronave: ");
                String modelo = in.nextLine();
                System.out.print("Número de série: ");
                String numeroSerie = in.nextLine();

                Aeronave aeronave = new Aeronave(modelo, numeroSerie);
                aeronave.adicionarPiloto(pilotoSelecionado);

                System.out.println("\nAeronave cadastrada com sucesso.");
                System.out.println(aeronave);

                voltarMenu(in);
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");
        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}