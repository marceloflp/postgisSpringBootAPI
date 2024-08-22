package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.model.MunicipioVO;
import br.com.example.repository.MunicipioRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class MunicipioController {
    
    @Autowired
    private MunicipioRepository repository;
     
    @GetMapping("/municipiosVizinhos/{nome}")
    public List<MunicipioVO> municipiosVizinhos(@PathVariable String nome){
        List<MunicipioVO> result = repository.listarMunicipiosVizinhos(nome);
        return result;
    }
   
    @GetMapping("/distanciaEntreMunicipios/{municipioA}/{municipioB}")
     public Double distanciaEntreMunicipios(@PathVariable String municipioA, @PathVariable String municipioB){
        double result = repository.distanciaEntreMunicipios(municipioA, municipioB);
        return result;
    }
    
    @GetMapping("/procurarPorSigla/{sigla}")
    public List<String> procurarPorSigla(@PathVariable String sigla){
    	List<String> mun = repository.procurarPorSigla(sigla);
    	return mun;
    }
    
    @GetMapping("/listarMunicipiosParaibanosComDivisaComPernambuco")
    public List<String> listarMunicipiosParaibanosComDivisaComPernambuco(){
    	List<String> mun = repository.listarMunicipiosParaibanosComDivisaComPernambuco();
    	return mun;
    }
    
    @GetMapping("/municipiosFronteiraEstado/{uf}")
    public List<String> municipiosFronteiraEstado(@PathVariable String uf){
    	List<String> mun = repository.municipiosFronteiraEstado(uf);
    	return mun;
    }
    
    @GetMapping("/listarMunicipiosPorEstado/{nome}")
    public List<String> listarMunicipiosPorEstado(@PathVariable String nome){
    	List<String> mun = repository.listarMunicipiosPorEstado(nome);
    	return mun;
    }
    
    @GetMapping("/quantidadeMunicipiosEstado/{uf}")
    public Integer quantidadeMunicipiosEstado(@PathVariable String uf) {
    	return repository.quantidadeMunicipiosEstado(uf);
    }
    
}