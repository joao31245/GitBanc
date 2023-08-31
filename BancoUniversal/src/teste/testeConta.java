package teste;
import br.com.bancouniversal.modelo.*;
import br.com.bancouniversal.database.*;
import java.util.*;
public class testeConta {
public static void main(String[] args) throws Exception {
	
	int resposta = 0;
	Scanner input = new Scanner(System.in);
	MySQLConnection connection = new MySQLConnection();
	
	connection.selectFromTable(6797);
	
	while(resposta != 3) {
		System.out.println("[ 1 ] Criar conta.");
		System.out.println("[ 2 ] Excluir conta");
		System.out.println("[ 3 ] Sair");
		resposta = input.nextInt();
		
		switch(resposta) {
		case 1: {
			System.out.println("---------");
		    String limpaCache = input.nextLine();
		    
			System.out.println("Qual o seu nome ?");
		    String name = input.nextLine();
		    
		    
		    System.out.println("Qual seu cpf ?");
		    String cpf = input.nextLine();

		    Cliente cliente = new Cliente(name, cpf);
		    System.out.println(cliente);
		    System.out.println(cliente.getConta());
		    // Chame o método para inserir o cliente no banco de dados, se necessário
		    // insertDataConta(cliente);
		    break;
			
		}
		case 2: {
			System.out.println("Conta excluida!");
			break;
		}
		case 3: {
			break;
		}
		default: {
			System.out.println("Tente novamente!");
			break;
		}
		}
//		
		}
}
}
