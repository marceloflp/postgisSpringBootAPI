package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.repository.FronteiraRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class FronteiraController {
    
    @Autowired
    private FronteiraRepository repository;
     
    @GetMapping("/listarMunicipiosComFronteiraPorRegiao/{regiao}")
    public List<String> listarMunicipiosComFronteiraPorRegiao(@PathVariable String regiao){
    	List<String> mun = repository.listarMunicipiosComFronteiraPorRegiao(regiao);
    	return mun;
    }
   
    @GetMapping("/listarMuncipiosComFronteiraPorEstado/{uf}")
    public List<String> listarMuncipiosComFronteiraPorEstado(@PathVariable String uf) {
        return repository.listarMuncipiosComFronteiraPorEstado(uf);
    }
}