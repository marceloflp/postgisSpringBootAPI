package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.repository.PortoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class PortoController {
	
	@Autowired
	private PortoRepository repository;
	
	@GetMapping("/portosPorRegiao/{regiao}")
	public List<String> portosPorRegiao(@PathVariable String regiao){
		List<String> porto = repository.portosPorRegiao(regiao);
		return porto;
	}
	
	@GetMapping("/quantidadePortosEstado/{uf}")
	public Integer quantidadePortosEstado(@PathVariable String uf) {
		return repository.quantidadePortosEstado(uf);
	}
	
}
