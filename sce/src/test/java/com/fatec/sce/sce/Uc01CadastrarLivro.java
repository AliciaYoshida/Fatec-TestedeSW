package com.fatec.sce.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.sce.model.FabricaDeConexoes;
import com.mysql.jdbc.Connection;

public class Uc01CadastrarLivro {

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com
	 * configuracao valida Pré-condição - a configuracao default da fabrica de
	 * conexoes é valida
	 */
	 @Test
	 public void quandoConectaComOBancoRetornaOK() {
	 // cenario
	 Connection c = null;
	 try {
	 // acao
	 c = new FabricaDeConexoes().getConnection();
	 // verificacao
	 assertNotNull(c);
	 } catch (Exception e) {
	 fail("nao deveria falhar");
	 }
	}

}
