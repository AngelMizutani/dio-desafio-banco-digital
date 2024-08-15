package poo_banco_digital;

public class ContaCorrente extends Conta{

	public ContaCorrente(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
	public void pagarConta(double valor, Conta conta) {
		super.sacar(valor, conta);
		super.imprimirComprovante("pagamento", valor, conta);
	}	
	
}
