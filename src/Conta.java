public class Conta {

    private int id;
    protected float saldo;
    private String nome;

    public Conta(int idConta, float saldoConta, String nomeCliente) {
        this.id = idConta;
        this.nome = nomeCliente;
    }

    public void deposito(float credito) {
        this.saldo = this.saldo + credito;
    }

    public void saque(float debito) {
        if ((this.saldo - debito) >= 0) {
            this.saldo = this.saldo - debito;
        } else {
            System.out.println("Você não pode sacar uma quantia maior que o seu saldo atual");
        }
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getSaldo() {
        return this.saldo;
    }

}
