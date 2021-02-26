package heroismarvel2;

import java.util.Scanner;

public class HeroisMarvel2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nome = new String[2];
        String[] poder = new String[2];
        int[] ano = new int[2];
        int[] per = new int[2];
        boolean[] dead = new boolean[2];

        int opc, num = 0;
        do {
            menu();
            opc = in.nextInt();
            in.nextLine();
            switch (opc) {
                case 1:
                    num = incluirPer(nome, poder, per, ano, dead, num);
                    break;
                case 2:
                    consultar(nome, poder, ano, num);
                    break;
                case 3:
                    num = remover(nome, poder, per, ano, dead, num);
                    break;
                case 4:
                    exibirPer(nome, poder, ano, num, dead);
                    break;
                case 5:
                    exibirClasses(nome, per, num);
                    break;
                case 6:
                    exibirSobreviveu(nome, dead, num);
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
                + " que sobreviveu ao thanos\n0-Encerrar");
    }

    public static int incluirPer(String[] no, String[] po, int[] per, int[] an, boolean[] morte, int num) {
        char respDead;
        Scanner in = new Scanner(System.in);

        if (num < no.length) {
            System.out.print("1-Heroi ou 2-vilão: ");
            per[num] = in.nextInt();
            while (per[num] < 1 || per[num] > 2) {
                System.out.print("Respsota invalida, digite 1 ou 2: ");
                per[num] = in.nextInt();
            }
            in.nextLine();
            System.out.print("Informe o nome do personagem: ");
            no[num] = in.nextLine();
            System.out.print("Informe o poder do personagem: ");
            po[num] = in.nextLine();
            System.out.print("Informe o ano de criação do personagem: ");
            an[num] = in.nextInt();
            while (an[num] < 1) {
                System.out.print("Respsota invalida, digite um valor maior que 0: ");
                an[num] = in.nextInt();
            }
            System.out.print("Foi morto pelo thanos? S-sim N-não: ");
            respDead = in.next().charAt(0);
            respDead = Character.toLowerCase(respDead);
            while (respDead != 's' && respDead != 'n') {
                System.out.print("Respsota invalida, digite S ou N: ");
                respDead = in.next().charAt(0);
                respDead = Character.toLowerCase(respDead);
            }
            if (respDead == 's') {
                morte[num] = true;
            } else {
                morte[num] = false;
            }
            num++;
            System.out.println("===================================================");
            System.out.println("Personagem cadastrado!");
            System.out.println("===================================================");
        } else {
            System.out.println("====================================");
            System.err.println("Cadastro cheio!");
            System.out.println("====================================");
        }
        return num;
    }

    public static void consultar(String[] no, String[] po, int[] an, int num) {
        Scanner in = new Scanner(System.in);
        int resp;
        if (num == 0) {
            System.out.println("===================================================");
            System.err.println("Nenhum cadastro para Consultar.");
            System.out.println("===================================================");
        } else {
            System.out.println("Informe a numeração do personagem: ");
            resp = in.nextInt() - 1;
            if (resp < num) {
                System.out.println("================================================");
                System.out.printf("Nome: %s\nPoder: %s\nAno de criação: %d\n",
                        no[resp], po[resp], an[resp]);
                System.out.println("================================================");
            } else {
                System.out.println("====================================");
                System.out.println("Posição não encontrada!");
                System.out.println("====================================");
            }
        }
    }

    public static int remover(String[] no, String[] po, int[] per, int[] an, boolean[] morte, int num) {
        Scanner in = new Scanner(System.in);
        int resp;
        if (num == 0) {
            System.out.println("===================================================");
            System.err.println("Nenhum cadastro para Remover.");
            System.out.println("===================================================");
        } else {
            System.out.println("Informe a numeração do personagem: ");
            resp = in.nextInt() - 1;
            if (resp < num) {
                for (int i = resp; i < num; i++) {
                    no[i] = no[i + 1];
                    po[i] = po[i + 1];
                    per[i] = per[i + 1];
                    an[i] = an[i + 1];
                    morte[i] = morte[i + 1];
                    num--;
                }
            } else {
                System.out.println("====================================");
                System.out.println("Posição não encontrada!");
                System.out.println("====================================");
            }
        }
        return num;
    }

    public static void exibirPer(String[] no, String[] po, int[] an, int num, boolean[] de) {
        String morte;
        if (num == 0) {
            System.out.println("===================================================");
            System.err.println("Nenhum cadastro para exibir.");
            System.out.println("===================================================");
        } else {
            System.out.println("personagens:");
            for (int i = 0; i < num; i++) {
                if (de[i] == true) {
                    morte = "SIM";
                } else {
                    morte = "NAO";
                }
                System.out.println("====================================");
                System.out.printf("%d- Nome: %s\nPoder: %s\nAno de criação: %d\nMorte pelo Thanos: %s\n",
                        (i + 1), no[i], po[i], an[i], morte);
            }
            System.out.println();
        }
    }

    public static void exibirClasses(String[] no, int[] per, int num) {
        if (num == 0) {
            System.out.println("===================================================");
            System.out.println("Nenhum cadastro para exibir.");
            System.out.println("===================================================");
        } else {
            System.out.println("Herois:");
            System.out.println("===================================================");
            for (int i = 0; i < num; i++) {
                if (per[i] == 1) {
                    System.out.printf("%s\n", no[i]);
                }
            }
            System.out.println("===================================================");
            System.out.println("Viloes:");
            System.out.println("===================================================");
            for (int i = 0; i < num; i++) {
                if (per[i] == 2) {
                    System.out.printf("%s\n", no[i]);
                }
            }
            System.out.println("===================================================");
        }
    }

    public static void exibirSobreviveu(String[] no, boolean[] de, int num) {
        if (num == 0) {
            System.out.println("===================================================");
            System.err.println("Nenhum cadastro para exibir.");
            System.out.println("===================================================");
        } else {
            System.out.println("===================================================");
            for (int i = 0; i < num; i++) {
                if (de[i] == false) {
                    System.out.printf("%s\n", no[i]);
                }
            }
            System.out.println("===================================================");
        }
    }
}
