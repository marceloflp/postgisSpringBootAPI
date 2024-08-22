/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Municipio;
import br.com.example.model.MunicipioVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author caian
 */
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

	@Query(value = "select new br.com.example.model.MunicipioVO(mb.codigo,mb.nome,mb.geometria) from Municipio ma, Municipio mb where touches(ma.geometria, mb.geometria) = true and ma.nome = :nome")
	List<MunicipioVO> listarMunicipiosVizinhos(String nome);

	@Query(value = "select distance(geography(ma.geometria), geograsphy(mb.geometria)) from Municipio ma, Municipio mb where ma.nome = :municipioA  and   mb.nome = :municipioB")
	public Double distanciaEntreMunicipios(String municipioA, String municipioB);

	@Query(value = "SELECT m.nome FROM Municipio m WHERE m.sigla = :sigla ORDER BY m.nome")
	List<String> procurarPorSigla(String sigla);


	@Query("SELECT m.nome FROM Municipio m, UnidadeFederativa uf "
			+ "WHERE Within(m.geometria, uf.geometria) AND uf.sigla = 'PB'"
			+ " AND Touches(m.geometria, (SELECT uf2.geometria FROM UnidadeFederativa uf2 WHERE uf2.sigla = 'PE'))")
	List<String> listarMunicipiosParaibanosComDivisaComPernambuco();

	@Query(value = "SELECT m.nome FROM Municipio m " +
            "INNER JOIN UnidadeFederativa e ON contains(e.geometria, m.geometria) = true " +
            "WHERE e.sigla = :uf " +
            "ORDER BY m.nome")
	List<String> municipiosFronteiraEstado(String uf);
	
	@Query(value = "select m.nome from Municipio m, UnidadeFederativa uf "
			+ "where within(m.geometria, uf.geometria) = true and uf.nome = :nome order by m.nome")
    List<String> listarMunicipiosPorEstado(String nome);
	
	@Query(value = "SELECT count(m.geometria) FROM Municipio m " +
            "INNER JOIN UnidadeFederativa uf ON within(m.geometria, uf.geometria) = true " +
            "WHERE uf.sigla = :uf")
	Integer quantidadeMunicipiosEstado(String uf);

}