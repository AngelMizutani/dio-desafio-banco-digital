package poo_banco_digital;

public interface IConta {
	void sacar(double valor, Conta conta);
	void depositar(double valor, Conta conta);
	void transferir(double valor, Conta contaSaida, Conta contaDestino);
	
	void imprimirExtrato();
	
}
