package br.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.example.model.Aeroporto;

public interface PortoRepository extends JpaRepository<Aeroporto, Long> {

	@Query(value = "SELECT m.nome FROM Municipio m " +
            "INNER JOIN Porto porto ON Within(porto.geometria, m.geometria) = true " +
            "WHERE porto.nome_regia = :regiao " +
            "ORDER BY m.nome")
	List<String> portosPorRegiao(String regiao);

	@Query(value = "SELECT count(porto.geometria) FROM Porto porto " +
            "INNER JOIN UnidadeFederativa uf ON within(porto.geometria, uf.geometria) = true " +
            "WHERE uf.sigla = :uf")
	Integer quantidadePortosEstado(String uf);
	
}
