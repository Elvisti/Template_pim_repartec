package br.unip.ads.pim.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unip.ads.pim.config.SwaggerConfig;
import br.unip.ads.pim.model.Chamado;
import br.unip.ads.pim.service.ChamadoService;
import io.swagger.annotations.Api;

@Api(tags = SwaggerConfig.TAG_CHAMADO)
@RestController
@RequestMapping("/api/chamados")
public class ChamadoRestController extends BaseRestController {

	@Autowired
	private ChamadoService chamadoService;

	@GetMapping
	public ResponseEntity<Iterable<Chamado>> buscarTodos() {
		Iterable<Chamado> chamados = chamadoService.buscarTodos();

		return ResponseEntity.ok().body(chamados);
	}

	@GetMapping("{id}")
	public ResponseEntity<Chamado> buscarUm(@PathVariable("id") Long id) {
		Chamado chamado = this.chamadoService.buscarUm(id);

		return ResponseEntity.ok().body(chamado);
	}

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Chamado chamado) {
		this.chamadoService.incluir(chamado);

		final URI uriChamado = super.criarUriPorId(chamado.getNumChamado());

		return ResponseEntity.created(uriChamado).build();
	}

	@PutMapping("{numChamado}")
	public ResponseEntity<Void> atualizar(@PathVariable("numChamado") Long numChamado, @RequestBody Chamado chamado) {
		chamado.setNumChamado(numChamado);
		this.chamadoService.atualizar(chamado);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{numChamado}")
	public ResponseEntity<Void> remover(@PathVariable("numChamado") Long numChamado) {
		this.chamadoService.remover(numChamado);

		return ResponseEntity.ok().build();
	}
}
