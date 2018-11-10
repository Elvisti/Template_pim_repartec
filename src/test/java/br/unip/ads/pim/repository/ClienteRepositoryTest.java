package br.unip.ads.pim.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unip.ads.pim.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void incluirCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("José");
		cliente.setCpf("12345678900");
		clienteRepository.save(cliente );
	}
}
