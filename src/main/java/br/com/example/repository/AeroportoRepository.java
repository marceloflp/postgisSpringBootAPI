package br.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.example.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
	
	@Query("select aero.municipio from Aeroporto aero where aero.estado = :estado")
	List<String> municipiosComAeroportosPorEstado(String estado);

	@Query(value = "SELECT m.nome FROM Municipio m " +
            "INNER JOIN Aeroporto ae ON Within(ae.geometria, m.geometria) = true " +
            "WHERE ae.nome_regia = :regiao " +
            "ORDER BY m.nome")
	List<String> aeroportosPorRegiao(String regiao);
	
	@Query(value = "SELECT count(uf.geometria) FROM UnidadeFederativa uf " +
            "INNER JOIN Aeroporto ae ON within(ae.geometria, uf.geometria) = true " +
            "WHERE ae.nome_regia = :regiao")
	Integer quantidadeAeroportoPorEstado(String regiao);
	
	@Query("select count(r.geometria) from Aeroporto r, Municipio m "
			+ "where within(r.geometria,m.geometria) = true and m.nome = :nome")
	Integer quantidadeAeroportosMunicipio(String nome);
}
