package com.fatec.sce.sce;
import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.sce.model.ConfiguraDB;
import com.fatec.sce.sce.model.FabricaDeConexoes;

import junit.framework.Assert; 

public class TestaConexaoComDB {
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// cenario
		FabricaDeConexoes fabrica;
		// acao
		fabrica = new FabricaDeConexoes();
		// verificacao
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de acesso invalida
	 * Pré-condição - a senha cadastrada é "aluno"
	 */
	 @Test
	 public void quandoConectaComSenhaInvalida_SQLException() {
	 // cenario
	 String url = "jdbc:mysql://localhost:3306/biblioteca";
	 String driver = "com.mysql.jdbc.Driver";
	 String usuario = "root";
	 String senha = ""; //senha errada
	 FabricaDeConexoes fabricaDeConexoes = null;
	 ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
	 fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
	 try {
	 //acao
	 fabricaDeConexoes.getConnection();
	 fail("deveria falhar");
	 } catch (Exception e) {
	 // verificacao
	 System.out.println(e.getMessage());
	 assertEquals(e.getMessage(),"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: NO)");
	 }
	 }
	 
	 @Test
	 public void quandoConectaComUsuarioInvalido_SQLException () {
		// cenario
		 String url = "jdbc:mysql://localhost:3306/biblioteca";
		 String driver = "com.mysql.jdbc.Driver";
		 String usuario = "r";
		 String senha = "alunofatec"; 
		 FabricaDeConexoes fabricaDeConexoes = null;
		 ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		 fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		 try {
		 //acao
		 fabricaDeConexoes.getConnection();
		 fail("deveria falhar");
		 } catch (Exception e) {
		 // verificacao
		 System.out.println(e.getMessage());
		 assertEquals(e.getMessage(),"java.sql.SQLException: Access denied for user '"+usuario+"'@'localhost' (using password: YES)");
	 }
	 }
	 
	 @Test
	 public void quandoISBNJaEstaCadastrado_SQLException() {
		 Livro isbn = new Livro();
		 isbn.setIsbn("1234");
		 
		 assertEquals("1234", isbn.getIsbn());
		 
		 
	 }
}
