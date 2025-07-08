import java.util.Scanner;

public class Main {
    public final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Cliente paulo = new Cliente("Paulo");
        Conta corrente = new ContaCorrente(1234, "436472-0", paulo);
        Conta poupanca = new ContaPoupanca(1234, "943728-6", paulo);

        double valor;
        int opcao;
        Conta contaSelecionada = null;

            System.out.printf("Olá, %s, qual conta você deseja utilizar?\n", paulo.getNome());
            System.out.println("[1] Conta Corrente");
            System.out.println("[2] Conta Poupança");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();
            switch (opcao){
                case 1 -> contaSelecionada = corrente;
                case 2 -> contaSelecionada = poupanca;
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }
        do {
            System.out.println("\nEscolha uma opção");
            System.out.println("________________________");
            System.out.println("[1] Imprimir extrato");
            System.out.println("[2] Depositar dinheiro");
            System.out.println("[3] Sacar dinheiro");
            System.out.println("[4] Transferir dinheiro para conta mesma titularidade.");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    contaSelecionada.extrato();
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito: ");
                    valor = sc.nextDouble();
                    contaSelecionada.depositar(valor);
                    break;
                case 3:
                    System.out.println("Digite o valor do saque: ");
                    valor = sc.nextDouble();
                    contaSelecionada.sacar(valor);
                    break;
                case 4:
                    System.out.println("Digite o valor da transferência: ");
                    valor = sc.nextDouble();
                    Conta destinatario = contaSelecionada == corrente ? poupanca : corrente;
                    contaSelecionada.transferir(valor, destinatario);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(true);
    }
}
