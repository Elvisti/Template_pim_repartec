package br.unip.ads.pim.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unip.ads.pim.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	// SELECT * FROM funcionario WHERE cpf = :cpf AND senha = :senha
	Funcionario findByCpfAndSenha(String cpf, String senha);
	
	// SELECT * FROM funcionario WHERE email = :email
	Funcionario findByCpf(String cpf);
}
