package br.com.bancouniversal.modelo;

public class Cliente {
private String nome;
private String cpf;
private Integer codigo;
private Conta conta;

public Cliente(String nome, String cpf) {
	
	RandomNumbers random = new RandomNumbers();
	Integer agencia = 22;
	Integer numero = random.generateRandomNumber(2);
	Double saldo = 1.0;
	
	this.codigo = random.generateRandomNumber(4);
	conta = new Conta(agencia, numero, saldo, codigo);
}
}
