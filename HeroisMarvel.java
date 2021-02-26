package heroismarvel;

import java.util.Scanner;

public class HeroisMarvel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[100];
        String[] nome = new String[100];
        String[] poder = new String[100];
        int[] ano = new int[100];
        boolean dead;
        int opc;
        menu();
        opc = in.nextInt();
        switch (opc) {
            case 1:
                break;
            case 2:
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
                System.err.printf( "%S \n","Programa encerrado");
                break;
            default:
                
        }
    }

    public static void menu() {

        System.out.println("1-Incluir Personagem\n2-Consultar personagem"
                + "\n3-Excluir personagem\n4-Lista todos os personagens\n"
                + "5-Lista por classes de personagem\n6-Lista personagens"
                + "que sobreviveu ao thanos\n0-Encerrar");
    }
}
