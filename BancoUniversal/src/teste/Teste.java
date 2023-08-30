package teste;
import br.com.bancouniversal.modelo.*;
public class Teste {
public static void main(String[] args) {
	RandomNumbers random = new RandomNumbers();
	
	Integer numeroAleatorio = random.generateRandomNumber(4);
	
	System.out.println(numeroAleatorio);
}
}
