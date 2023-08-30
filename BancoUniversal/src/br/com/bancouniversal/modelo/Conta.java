package br.com.bancouniversal.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bancouniversal.database.MySQLConnection;
import br.com.bancouniversal.exeption.*;
import br.com.bancouniversal.database.*;
public class Conta {
private Integer numero;
private Integer agencia;
private Double saldo;
private Integer codigo;
private MySQLConnection connection;

public Conta(Integer numero, Integer agencia, Double saldo, Integer codigo) {
	connection = new MySQLConnection();
	this.setNumero(numero);
	this.setAgencia(agencia);
	this.deposita(saldo);
	this.setCodigo(codigo);
	connection.insertDataConta(this);
}

public Integer getCodigo() {
	return codigo;
}

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}


public void deposita(Double valor) {
	this.saldo =+ valor;
	
}

public void saca(Double valor) {
	if(this.getSaldo() < valor) {
		throw new WithoutMoneyExeption();
	}
	this.saldo -= valor;
	Double novoSaldo = this.saldo;
	
}

public void transfere(Conta conta, Double Valor) {
	
}

public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public Integer getAgencia() {
	return agencia;
}

public void setAgencia(Integer agencia) {
	this.agencia = agencia;
}

public Double getSaldo() {
	return saldo;
}

}
