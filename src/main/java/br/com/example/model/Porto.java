package br.com.example.model;

import java.io.Serializable;

import org.locationtech.jts.geom.Geometry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "porto_2014")
public class Porto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	@Column(nullable = true)
	private Double object_1; 
	private String uf;
	@Column(name = "nome_uf")
	private String estado;
	private String nome_regia;
	private String municipio;
	private Integer codmun;
	private Long sum_total;
	@Column(name = "geom")
	private Geometry geometria;
	
}
