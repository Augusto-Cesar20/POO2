package Principal;

import java.sql.SQLException;

import DB.DB;

public class Principal {

	public static void main(String[] args) throws SQLException {
		
		if(DB.getConexao()!= null) {
			System.out.println("Conexão realizada!");
		}
	}
}
