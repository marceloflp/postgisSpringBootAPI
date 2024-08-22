/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;


import java.io.Serializable;

import org.locationtech.jts.geom.Geometry;

public class MunicipioVO implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private String codigo;
    private String nome;
    private Geometry geometria;
    
    public MunicipioVO(String codigo, String nome, Geometry geometria) {
    	this.codigo = codigo;
    	this.nome = nome;
    	this.geometria = geometria;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Geometry getGeometria() {
		return geometria;
	}

	public void setGeometria(Geometry geometria) {
		this.geometria = geometria;
	}
    
    
}
