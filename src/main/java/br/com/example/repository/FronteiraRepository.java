package br.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.example.model.Fronteira;

public interface FronteiraRepository extends JpaRepository<Fronteira, Long> {
	
	@Query("SELECT f.municipio " +
			   "FROM Fronteira f " +
			   "WHERE f.regiao = :regiao " +
			   "ORDER BY f.municipio")
		List<String> listarMunicipiosComFronteiraPorRegiao(String regiao);
	
	@Query(value = "SELECT f.municipio FROM Fronteira f "
			+ "INNER JOIN UnidadeFederativa uf ON within(f.geometria, uf.geometria) = true " 
			+ "WHERE uf.nome = :estado")
	List<String> listarMuncipiosComFronteiraPorEstado(String estado);

}
