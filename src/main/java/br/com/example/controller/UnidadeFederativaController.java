package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.repository.UnidadeFederativaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class UnidadeFederativaController {
    
    @Autowired
    private UnidadeFederativaRepository repository;
     
    @GetMapping("/listarEstadosPorRegiao/{regiao}")
    public List<String> listarEstadosPorRegiao(@PathVariable String regiao){
    	List<String> regioes = repository.listarEstadosPorRegiao(regiao);
    	return regioes;
    }
    
    @GetMapping("/listarRegioes")
    public List<String> listarRegioes(){
    	return repository.listarRegioes();
    }
    
    @GetMapping("/listarEstadosVizinhos/{estado}")
    public List<String> listarEstadosVizinhos(@PathVariable String estado){
    	List<String> mun = repository.listarEstadosVizinhos(estado);
    	return mun;
    }
   
    @GetMapping("/distanciaEntreEstados/{sigla1}/{sigla2}")
    public Double distanciaEntreEstados(@PathVariable String sigla1,@PathVariable String sigla2) {
    	Double dist = repository.distanciaEntreEstados(sigla1, sigla2);
        return dist;
    }
    
}