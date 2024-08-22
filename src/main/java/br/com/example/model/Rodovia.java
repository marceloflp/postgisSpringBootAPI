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
@Table(name = "rodovia_2014")
public class Rodovia implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gid;
	private Integer objectid;
	private String descseg;
	private String tipopnv;
	private String codigo;
	@Column(name = "geom")
	private Geometry geometria;
}
