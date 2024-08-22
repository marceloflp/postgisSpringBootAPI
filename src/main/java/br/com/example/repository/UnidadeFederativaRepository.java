package br.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.example.model.UnidadeFederativa;

public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, Integer> {

	@Query("SELECT uf.nome FROM UnidadeFederativa uf " 
	+ "WHERE uf.regiao = :regiao " 
	+ "ORDER BY uf.nome")
	List<String> listarEstadosPorRegiao(String regiao);
	
	@Query("SELECT regiao FROM UnidadeFederativa GROUP BY regiao ORDER BY regiao")
    List<String> listarRegioes();
	
	@Query("select uf2.nome from UnidadeFederativa uf1, UnidadeFederativa uf2 "
			+ "where touches(uf1.geometria, uf2.geometria) = true and uf1.nome = :estado")
	List<String> listarEstadosVizinhos(String estado);
	
	@Query("SELECT distance(geography(uf1.geometria), geography(uf2.geometria)) "
			+ "FROM UnidadeFederativa uf1, UnidadeFederativa uf2 " +
            "WHERE uf1.sigla = :sigla1 AND uf2.sigla = :sigla2")
	Double distanciaEntreEstados(String sigla1, String sigla2);

}
