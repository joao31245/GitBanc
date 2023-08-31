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
	private double saldo;
	private Integer codigo;
	private MySQLConnection connection;

	public Conta(Integer numero, Integer agencia, double saldo, Integer codigo) throws Exception {
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

	public void deposita(double valor) {
		this.saldo = +valor;
	//	connection.updateData(valor, this.codigo);
	}

	public void saca(double valor) {
		if (this.getSaldo() < valor) {
			throw new WithoutMoneyExeption();
		}
		this.saldo -= valor;
		double novoSaldo = this.saldo;

	}

	public void transfere(Conta conta, double Valor) {

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

	public double getSaldo() {
		return saldo;
	}
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Codigo:" + this.getCodigo() + " Numero: "
			+ this.getNumero() +
			" Agencia" + this.getAgencia() +
			" Saldo: " + this.getSaldo();
}
}
