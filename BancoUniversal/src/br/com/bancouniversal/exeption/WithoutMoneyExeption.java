package br.com.bancouniversal.exeption;

public class WithoutMoneyExeption extends RuntimeException{

	public WithoutMoneyExeption() {
		System.out.println("Dinheiro insuficiente");
		this.getStackTrace();
		
	}
}
