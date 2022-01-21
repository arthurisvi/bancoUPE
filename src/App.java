import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner menu = new Scanner(System.in);
        ColecaoDeContas banco = new ColecaoDeContas();
        int opcao;

        do {
            System.out.println("\nBANCO UPE");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Remover conta");
            System.out.println("4 - Depósito");
            System.out.println("5 - Saque");
            System.out.println("6 - Sair");
            System.out.println("\nEscolha uma opção acima: ");
            opcao = menu.nextInt();

            switch (opcao) {
                case 1:
                    banco.addConta();
                    break;
                case 2:
                    banco.listarContas();
                    break;
                case 3:
                    banco.removerConta();
                    break;
                case 4:
                    System.out.println("\n---------- DEPÓSITO ----------");
                    System.out.print("\n1- Conta corrente");
                    System.out.println("\n2- Conta poupança");
                    System.out.println("Tipo da conta:");
                    int tipoConta = menu.nextInt();
                    System.out.println("\nInforme o número da conta desejada:");
                    int idConta = menu.nextInt();
                    System.out.println("Informe o valor do depósito:");
                    float deposito = menu.nextFloat();
                    banco.buscarConta(idConta).deposito(deposito);

                    if (tipoConta == 2) {
                        if (banco.isPoupanca(idConta)) {
                            Poupanca contaP;
                            contaP = (Poupanca) banco.buscarConta(idConta);
                            contaP.renderJuros(50);
                        } else {
                            System.out.println("A conta solicitada não é do tipo poupança.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n---------- SAQUE ----------");
                    System.out.println("\nInforme o número da conta desejada:");
                    int idConta2 = menu.nextInt();
                    System.out.println("Informe o valor do saque:");
                    float saque = menu.nextFloat();
                    banco.buscarConta(idConta2).saque(saque);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nDigite uma opção válida");
                    break;
            }
        } while (opcao != 6);
        menu.close();

    }
}
