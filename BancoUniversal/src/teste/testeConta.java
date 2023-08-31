package teste;
import br.com.bancouniversal.modelo.*;
import java.util.*;
public class testeConta {
public static void main(String[] args) {
	
	int resposta = 0;
	Scanner input = new Scanner(System.in);
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
		    System.out.println("Nome: " + cliente.getNome());
		    System.out.println("CPF: " + cliente.getCpf());

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
		
		}
}
}
