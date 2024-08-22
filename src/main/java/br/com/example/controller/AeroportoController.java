package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.repository.AeroportoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class AeroportoController {
	
	@Autowired
	private AeroportoRepository repository;

	@GetMapping("/municipiosComAeroportosPorEstado/{estado}")
	public List<String> municipiosComAeroportosPorEstado(@PathVariable String estado){
		List<String> aero = repository.municipiosComAeroportosPorEstado(estado);
		return aero;
	}
	
	@GetMapping("/aeroportosPorRegiao/{regiao}")
	public List<String> aeroportosPorRegiao(@PathVariable String regiao){
		List<String> aero = repository.aeroportosPorRegiao(regiao);
		return aero;
	}
	
	@GetMapping("/quantidadeAeroportoPorEstado/{regiao}")
	public Integer quantidadeAeroportoPorEstado(@PathVariable String regiao) {
		return repository.quantidadeAeroportoPorEstado(regiao);
	}
	
	@GetMapping("/quantidadeAeroportosMunicipio/{municipio}")
	public Integer quantidadeAeroportosMunicipio(@PathVariable String municipio) {
		return repository.quantidadeAeroportosMunicipio(municipio);
	}
}
