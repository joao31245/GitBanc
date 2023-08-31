package br.com.bancouniversal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxExpect;

import br.com.bancouniversal.modelo.Cliente;
import br.com.bancouniversal.modelo.Conta;

public class MySQLConnection implements AutoCloseable{
	 
		private static final String URL = "jdbc:mysql://localhost:3306/banco";
	    private static final String USER = "root";
	    private static final String PASSWORD = "duda#123A";
	    private static Connection connection;

	    public static Connection getConnection(){
	    	 try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", 
	    				"root", "duda#123A");
	    		System.out.println("Conexão bem sucedida!");
	    	} catch (SQLException e) {
				System.out.println("E");
				e.getStackTrace();
			} catch(ClassNotFoundException e) {
				System.out.println("Driver não encontrado");
			}
	    	return connection;

	    }
	    
	    public void insertDataConta(Conta conta) throws Exception {
	    	String insertQuery = "INSERT INTO Conta(codigo,numero,agencia,saldo) values(?,?,?,?)";
	    	
	    	try(	Connection connection =
	    			MySQLConnection.getConnection();
	    			PreparedStatement preparedStatement = 
	    			connection.prepareStatement(insertQuery)) {
	    		
	    		preparedStatement.setInt(1, conta.getCodigo());
	    		preparedStatement.setInt(2, conta.getNumero());
	    		preparedStatement.setInt(3, conta.getAgencia());
	    		preparedStatement.setDouble(4, conta.getSaldo());
	    		
	    		int rowsAffected = preparedStatement.executeUpdate();
	    		System.out.println("Sucesso ao inserir dados.");
	    		
	    	} catch(SQLException e) {
	    		System.out.println("Falha ao inserir dados.");
				e.getStackTrace();
			} finally {
				close();
			}
	    	
	    }
	    
	    public void insertDataCliente(Cliente cliente) {
	    	String insertQuerry = "INSERT INTO Clientes(nome,cpf,codigo) VALUES(?,?,?)";
	    	try(Connection connection =
	    		MySQLConnection.getConnection();
	    		PreparedStatement preparedStatement = 
	    		connection.prepareStatement(insertQuerry)) {
	    		
	    		preparedStatement.setString(1, cliente.getNome());
	    		preparedStatement.setString(2, cliente.getCpf());
	    		preparedStatement.setInt(3, cliente.getCodigo());
	    		int rowsAffected = preparedStatement.executeUpdate();
	    		System.out.println("Dados de cliente inseridos!");
	    	}
	    	catch(SQLException ex) {
	    		System.out.println("Erro de conexão");
	    	}
	    }
	    
	    public void updateData( Double update, Integer codigo ) {
	    	String updateQuery = "UPDATE conta set saldo ? WHERE codigo = ?";
	    	try(Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	    		preparedStatement.setDouble(1, update);
	    		preparedStatement.setInt(2, codigo);
	    		preparedStatement.executeUpdate();
 	    	} catch(SQLException ex) {
 	    		System.out.println("Falha no update");
 	    		ex.getStackTrace();
 	    	}
	    }
	    
	    public void selectFromTable(int codigo) {
	    	String select = "SELECT * FROM  Clientes WHERE codigo = " + codigo ;
	    	try(Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(select);) {
	    		System.out.println("Deu certo");
	    		
	    	try (ResultSet resultSet = preparedStatement.executeQuery()) {
	             while (resultSet.next()) {
	               int coluna1 = resultSet.getInt("id"); // Substitua 'nome_da_coluna1' pelo nome da coluna
	               String coluna2 = resultSet.getString("nome"); // Substitua 'nome_da_coluna2' pelo nome da coluna
	               String coluna3 = resultSet.getString("cpf");
	               int coluna4 = resultSet.getInt("codigo");
	                // Continue lendo os valores das outras colunas conforme necessário
	                
	                System.out.println("Coluna1: " + coluna1 +
	                		", Coluna2: " + coluna2
	                		+ ", Coluna3: " + coluna3 
	                		+ ", Coluna2: " + coluna4);
	                }
	            }
	    	} catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	
	    }
	    
	    public static void closeConnection(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	                System.out.println("Conexão fechada.");
	            } catch (SQLException e) {
	                System.out.println("Erro ao fechar a conexão!");
	                e.printStackTrace();
	            }
	        }
	    }

		@Override
		public void close() throws Exception {
			// TODO Auto-generated method stub
			closeConnection(getConnection());
			System.out.println("Fechando conexão");
		}
}
