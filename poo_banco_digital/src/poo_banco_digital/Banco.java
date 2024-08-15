package poo_banco_digital;

import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void imprimirRelatorioClientes() {
		System.out.println("=== Relatório de Clientes ===");
		for (Conta conta : contas) {
			System.out.println(String.format("Cliente: %s", conta.cliente.getNome()));
			System.out.println(String.format("Numero: %d", conta.getNumero()));
			System.out.println(String.format("Saldo: %.2f\n", conta.getSaldo()));
		}
	}

}
