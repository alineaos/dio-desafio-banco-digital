public abstract class Conta implements ContaFuncoes{
    private int agencia;
    private String numero;
    private double saldo;
    private Cliente Cliente;

    public Conta(int agencia, String numero, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        Cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(saldo < valor){
            System.out.println("A conta não pode ficar com o saldo negativo.");
            return;
        }
        this.saldo -= valor;
        System.out.printf("Você sacou R$%.2f.\n", valor);
    }

    @Override
    public void depositar(double valor) {
        if(valor < 0){
            System.out.println("O valor depositado não pode ser negativo.");
            return;
        }
        this.saldo += valor;
        System.out.printf("Você depositou R$%.2f.\n", valor);
    }

    @Override
    public void transferir(double valor, Conta destinatario) {
        if(saldo < valor){
            System.out.println("A conta não pode ficar com o saldo negativo.");
            return;
        }
        this.saldo -= valor;
        destinatario.saldo += valor;
        System.out.println("Tranferência feita com sucesso.");
    }

    @Override
    public void extrato() {
        System.out.printf("Saldo da conta: R$ %.2f\n", this.saldo);
    }
}
