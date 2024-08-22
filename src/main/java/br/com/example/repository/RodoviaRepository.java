package br.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.example.model.Rodovia;

public interface RodoviaRepository extends JpaRepository<Rodovia, Integer> {
	
	@Query("select count(r.geometria) from Rodovia r, Municipio m "
			+ "where within(r.geometria,m.geometria) = true and m.nome = :nome")
	Integer quantidadeRodoviasMunicipio(String nome);
	
	 @Query(value = "SELECT count(r.geometria) FROM UnidadeFederativa uf " +
             "INNER JOIN Rodovia r ON within(r.geometria, uf.geometria) = true " +
             "WHERE uf.sigla = :uf")
	 Integer quantidadeRodoviasEstado(String uf);
	 
	 @Query("select r.tipopnv from Municipio m "
	 		+ "inner join Rodovia r on within(r.geometria, m.geometria) = true "
	 		+ "where m.nome = :municipio")
	 List<String> tipoDeRodoviaPorMunicipio(String municipio);
}
