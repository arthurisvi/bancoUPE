import java.util.Scanner;
import java.util.ArrayList;

public class ColecaoDeContas {

    ArrayList<Conta> listaContas = new ArrayList<Conta>();
    Conta auxConta;

    public void addConta() {
        Scanner cadastrar = new Scanner(System.in);

        System.out.print("\nDigite o nome: ");
        String nomeCliente = cadastrar.nextLine();
        System.out.print("Digite o número da conta: ");
        int idCliente = cadastrar.nextInt();
        System.out.print("\n1- Conta corrente");
        System.out.println("\n2- Conta poupança");
        System.out.println("Tipo da conta:");
        int tipoConta = cadastrar.nextInt();
        float saldoCliente = 0;

        if (tipoConta == 1) {
            Conta novaContaC = new Conta(idCliente, saldoCliente, nomeCliente);
            listaContas.add(novaContaC);
        } else if (tipoConta == 2) {
            Conta novaContaP = new Poupanca(idCliente, saldoCliente, nomeCliente);
            listaContas.add(novaContaP);
        }
    }

    public void removerConta() {

        if (listaContas.size() == 0) {
            System.out.println("\nNão há contas cadastradas.");
        } else {
            Scanner remover = new Scanner(System.in);

            System.out.print("\nDigite o número da conta que deseja remover: ");
            int idConta = remover.nextInt();

            for (int i = 0; i < listaContas.size(); i++) {
                if (listaContas.get(i).getId() == idConta) {
                    listaContas.remove(i);
                    break;
                }

            }
        }

    }

    public boolean isPoupanca(int numeroConta) {
        for (int i = 0; i < listaContas.size(); i++) {
            if (listaContas.get(i) instanceof Poupanca) {
                return true;
            }
        }
        return false;
    }

    public void listarContas() {

        if (listaContas.size() == 0) {
            System.out.println("\nNão há contas cadastradas.");
        }

        System.out.println("\n---------- CORRENTISTAS ----------");

        for (int i = 0; i < listaContas.size(); i++) {

            if (listaContas.get(i) instanceof Poupanca) {
                System.out.println("\n---------- POUPANÇA ----------");
                System.out.println("Conta: " + listaContas.get(i).getId());
                System.out.println("Nome: " + listaContas.get(i).getNome());
                System.out.println("Saldo: " + listaContas.get(i).getSaldo());
                System.out.println("---------------------------------");

            } else {
                System.out.println("\n---------- CORRENTE  ----------");
                System.out.println("Conta: " + listaContas.get(i).getId());
                System.out.println("Nome: " + listaContas.get(i).getNome());
                System.out.println("Saldo: " + listaContas.get(i).getSaldo());
                System.out.println("---------------------------------");

            }

        }
    }

    public Conta buscarConta(int idConta) {
        for (int i = 0; i < listaContas.size(); i++) {
            if (idConta == listaContas.get(i).getId()) {
                auxConta = listaContas.get(i);
            }
        }
        return auxConta;
    }
}
