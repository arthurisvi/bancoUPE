public class Poupanca extends Conta{

    public Poupanca (int idConta, float saldoConta, String nomeCliente){
        super(idConta, saldoConta, nomeCliente);
    }
    
    public void renderJuros (float juros){
        this.saldo += (this.saldo * juros/100);

    }
}
