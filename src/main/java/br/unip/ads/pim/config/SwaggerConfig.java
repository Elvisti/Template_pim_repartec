package br.unip.ads.pim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String TAG_CHAMADO = "Chamados";
	public static final String TAG_CLIENTE = "Clientes";
	public static final String TAG_FUNCIONARIO = "Funcionarios";
	public static final String TAG_USUARIO = "Usuarios";

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.unip.ads.pim.controller"))
				.build()
				.apiInfo(apiInfo())
				.tags(new Tag(TAG_CHAMADO, "Opera��es relacionadas ao dom�nio de Chamados")
					, new Tag(TAG_CLIENTE, "Opera��es relacionadas ao dom�nio de Clientes")
					, new Tag(TAG_FUNCIONARIO, "Opera��es relacionadas ao dom�nio de Funcionarios")
					, new Tag(TAG_USUARIO, "Opera��es relacionadas ao dom�nio de Usuarios"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Documenta��o API REST (PIM)")
				.version("1.0.0")
				.build();
	}

}