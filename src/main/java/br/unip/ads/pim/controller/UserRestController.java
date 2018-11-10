package br.unip.ads.pim.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unip.ads.pim.config.SwaggerConfig;
import br.unip.ads.pim.model.Funcionario;
import br.unip.ads.pim.service.UsuarioService;
import io.swagger.annotations.Api;

@Api(tags = SwaggerConfig.TAG_USUARIO)
@RestController
@RequestMapping("/api/usuarios")
public class UserRestController extends BaseRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("eu")
	public ResponseEntity<Funcionario> eu(Principal principal) {
		String cpf = principal.getName();
		Funcionario usuarioLogado = usuarioService.login(cpf);
		return ResponseEntity.ok().body(usuarioLogado);
	}
}












