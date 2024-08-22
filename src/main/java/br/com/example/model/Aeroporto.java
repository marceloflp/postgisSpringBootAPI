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
@Table(name = "aeroportos_2014")
public class Aeroporto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	@Column(nullable = true)
	private Double object_1; 
	private String municdv;
	private String uf;
	@Column(name = "nome_uf")
	private String estado;
	private String nome_regia;
	private String municipio;
	private Long pax2010;
	private Long internacio;
	@Column(name = "geom")
	private Geometry geometria;
	
}
