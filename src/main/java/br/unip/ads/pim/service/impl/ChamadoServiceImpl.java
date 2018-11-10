package br.unip.ads.pim.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Chamado;
import br.unip.ads.pim.model.ChamadoStatus;
//import br.unip.ads.pim.model.Cliente;
//import br.unip.ads.pim.model.Funcionario;
import br.unip.ads.pim.repository.ChamadoRepository;
//import br.unip.ads.pim.repository.ClienteRepository;
//import br.unip.ads.pim.repository.FuncionarioRepository;
import br.unip.ads.pim.service.ChamadoService;
import br.unip.ads.pim.utils.ExcecaoNegocial;

@Service
public class ChamadoServiceImpl implements ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	//@Autowired
	//private FuncionarioRepository funcionarioRepository;

	@Override
	public void incluir(Chamado chamado) {
		if (chamado.getNumChamado() != null) {
			throw new ExcecaoNegocial("O ID não deve ser especificado.");
		}
		int cargoFuncionario = chamado.getFuncionario().getCargo();
		//Long idFuncionario = chamado.getFuncionario().getId();
		//Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		if (cargoFuncionario != 1) {
			throw new ExcecaoNegocial("Apenas Atendentes podem abrir chamados.");
		}
		chamado.setStatus(ChamadoStatus.ABERTO);
		chamado.setInicio(LocalDateTime.now());
		this.chamadoRepository.save(chamado);
	}

	@Override
	public Iterable<Chamado> buscarTodos() {
		return this.chamadoRepository.findByStatusInOrderByInicioAsc(
				ChamadoStatus.ABERTO, 
				ChamadoStatus.EM_ANDAMENTO);
	}

	@Override
	public Chamado buscarUm(Long numChamado) {
		Optional<Chamado> chamado = this.chamadoRepository.findById(numChamado);
		return chamado.orElseThrow(() -> new ExcecaoNegocial("Número de Chamado não localizado."));
	}

	@Override
	public void atualizar(Chamado chamado) {
		if (chamado.getNumChamado() == null) {
			throw new ExcecaoNegocial("O Número do Chamado deve ser especificado.");
		}
		this.chamadoRepository.save(chamado);
	}

	@Override
	public void remover(Long numChamado) {
		this.chamadoRepository.deleteById(numChamado);
	}

}
