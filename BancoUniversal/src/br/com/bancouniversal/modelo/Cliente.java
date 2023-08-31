package br.com.bancouniversal.modelo;
import br.com.bancouniversal.database.*;

public class Cliente {
private String nome;
private String cpf;
private static Integer codigo;
private Conta conta;
private static MySQLConnection connection;

public Cliente(String nome, String cpf) throws Exception {
	
	connection = new MySQLConnection();
	
	this.setCodigo(codigo);
	this.setNome(nome);
	this.setCpf(cpf);
	
	RandomNumbers random = new RandomNumbers();
	Integer agencia = 22;
	Integer numero = random.generateRandomNumber(2);
	Double saldo = 1.0;
	
	this.codigo = random.generateRandomNumber(4);
	
	connection.insertDataCliente(this);
	
	conta = new Conta(agencia, numero, saldo, this.codigo);
	
	this.setConta(conta);
}

@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Cliente cast = (Cliente) obj;
		if(this.getNome() == cast.getNome() &&
			this.getCpf() == cast.getCpf()) {
			return true;
		} else {
			return false;
		}
	}

public String getNome() {
	return nome;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Titular:" + this.getNome() + " Cpf:"  + this.getCpf() + " Codigo:" + this.getCodigo();
	}

public void setNome(String nome) {
	this.nome = nome;
}


public String getCpf() {
	return cpf;
}


public void setCpf(String cpf) {
	this.cpf = cpf;
}


public Integer getCodigo() {
	return codigo;
}


public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}


public Conta getConta() {
	return conta;
}


public void setConta(Conta conta) {
	this.conta = conta;
}

}

