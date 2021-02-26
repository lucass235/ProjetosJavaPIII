package heroismarvel2;

import java.util.Scanner;

public class HeroisMarvel2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nome = new String[2];
        String[] poder = new String[2];
        int[] ano = new int[2];
        boolean dead;
        int num = 0;
        int opc, resp;
        do {
            menu();
            opc = in.nextInt();
            in.nextLine();
            switch (opc) {
                case 1:
                    if (num < nome.length) {
                        System.out.println("Informe o nome do personagem: ");
                        nome[num] = in.nextLine();
                        System.out.println("Informe o poder do personagem: ");
                        poder[num] = in.nextLine();
                        System.out.println("Informe o ano de criação do personagem: ");
                        ano[num] = in.nextInt();
                        num++;
                    } else {
                        System.out.println("====================================");
                        System.err.println("Cadastro cheio!");
                        System.out.println("====================================");
                    }
                    break;
                case 2:
                    System.out.println("Informe a numeração do personagem: ");
                    resp = in.nextInt() - 1;
                    if (resp < num) {
                        System.out.printf("Nome %s\nPoder: %s\nAno de criação: %d\n",
                                nome[resp], poder[resp], ano[resp]);
                    } else {
                        System.out.println("====================================");
                        System.out.println("Posição não encontrada!");
                        System.out.println("====================================");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("====================================");
                    System.err.printf("%S \n", "Programa encerrado");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("====================================");
                    System.err.println("Opção incorreta!");
                    System.out.println("====================================");
            }
        } while (opc != 0);
    }

    public static void menu() {

        System.out.println("1-Incluir Personagem\n2-Consultar personagem"
                + "\n3-Excluir personagem\n4-Lista todos os personagens\n"
                + "5-Lista por classes de personagem\n6-Lista personagens"
                + "que sobreviveu ao thanos\n0-Encerrar");
    }

}
