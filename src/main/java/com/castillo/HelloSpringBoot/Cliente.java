package com.castillo.HelloSpringBoot;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

//@XmlRootElement
public class Cliente {

	private long idCliente;
	private String content;

	@JsonProperty("localidad")
	private String municipio;

	

	public Cliente(long idCliente, String content, String municipio) {
		this.idCliente = idCliente;
		this.content = content;
		this.municipio = municipio;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", content=" + content + "]";
	}

}
