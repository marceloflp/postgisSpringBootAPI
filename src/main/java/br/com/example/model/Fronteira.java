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
@Table(name = "pontos_fronteira_2014")
public class Fronteira implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	private Integer object_1;
	private String municdv;
	private String uf;
	@Column(name = "nome_uf")
	private String estado;
	@Column(name = "nome_regia")
	private String regiao;
	private String municipio;
	private String admnistra;
	private Geometry geometria;

}
