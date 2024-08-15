package poo_banco_digital;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco("Nosso Banco");
		List<Conta> contas = new ArrayList<>();
		
		Cliente cliente = new Cliente("Zelda", "123");
		Conta cc = new ContaCorrente(cliente);
		contas.add(cc);
		Conta poupanca = new ContaPoupanca(cliente);
		contas.add(poupanca);
		
		Cliente cliente2 = new Cliente("Fiona", "456");
		ContaCorrente cc2 = new ContaCorrente(cliente2);
		contas.add(cc2);
		Conta poupanca2 = new ContaPoupanca(cliente2);
		contas.add(poupanca2);
		
		banco.setContas(contas);
		
		cc.depositar(200, cc);
		cc.transferir(50.00, cc, poupanca);
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		cc.transferir(70.00, cc, poupanca2);
		poupanca2.imprimirExtrato();
		
		banco.imprimirRelatorioClientes();
	
	}

}
