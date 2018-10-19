package com.fatec.sce.sce;

import static org.junit.Assert.fail;

import org.junit.Test;

public class Uc02UsuarioInvalido {

	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			/*Usuario umUser = new Usuario();
			// acao
			umUser.setUser("121212");
*/		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}

	}
}
