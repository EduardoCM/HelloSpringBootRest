package com.castillo.HelloSpringBoot;

public class Cliente {

	private long idCliente;
	private String content;
	
	

	public Cliente(long idCliente, String content) {
		this.idCliente = idCliente;
		this.content = content;
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", content=" + content + "]";
	}
	
}
