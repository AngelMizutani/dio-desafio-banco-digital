package poo_banco_digital;

public abstract class Conta implements IConta{
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
		

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	protected void imprimirComprovante(String movimentacao, double valor, Conta conta) {
		System.out.println(String.format("=== Comprovante de %s ===", movimentacao));
		System.out.println(String.format("Valor: %.2f", valor));
		
		if (movimentacao.equals("deposito") || movimentacao.equals("transferencia") ) {
			System.out.println(String.format("Destino: %s", conta.cliente.getNome()));
		} else {
			System.out.println(String.format("Conta debitada: %s", conta.cliente.getNome()));
		}
	}

	@Override
	public void sacar(double valor, Conta conta) {
		// TODO Auto-generated method stub
		saldo -= valor;
		imprimirComprovante("saque", valor, conta);
	}

	@Override
	public void depositar(double valor, Conta conta) {
		// TODO Auto-generated method stub
		saldo += valor;
		imprimirComprovante("deposito", valor, conta);
		
	}

	@Override
	public void transferir(double valor, Conta contaSaida, Conta contaDestino) {
		// TODO Auto-generated method stub
		this.sacar(valor, contaSaida); //estou sacando desta conta
		contaDestino.depositar(valor, contaDestino); //e depositando na conta destino
		imprimirComprovante("transferencia", valor, contaDestino);
	}
	
}
