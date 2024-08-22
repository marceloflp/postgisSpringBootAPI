package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.repository.RodoviaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class RodoviaController {
	
	@Autowired
	private RodoviaRepository repository;
	
	@GetMapping("/quantidadeRodoviasMunicipio/{nome}")
	public Integer quantidadeRodoviasMunicipio(@PathVariable String nome) {
		return repository.quantidadeRodoviasMunicipio(nome);
	}
	
	@GetMapping("/quantidadeRodoviasEstado/{uf}")
	public Integer quantidadeRodoviasEstado(@PathVariable String uf) {
		return repository.quantidadeRodoviasEstado(uf);
	}
	
	@GetMapping("/tipoDeRodoviaPorMunicipio/{municipio}")
	public List<String> tipoDeRodoviaPorMunicipio(@PathVariable String municipio) {
		List<String> rod = repository.tipoDeRodoviaPorMunicipio(municipio);
		return rod;
	}
	
}
