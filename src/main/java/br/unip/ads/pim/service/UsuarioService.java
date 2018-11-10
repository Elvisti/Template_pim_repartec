package br.unip.ads.pim.service;

import br.unip.ads.pim.model.Funcionario;

public interface UsuarioService {
	
	Funcionario login(String cpf);
}
