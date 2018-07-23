package com.castillo.HelloSpringBoot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private static final String template = "Nuevo Cliente, %s";
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping("/getClientes")
	public List<Cliente> getClientes(){
		System.out.println(":::::::::: Inicio de ejecucion para solicitar clientes :::::::::");
		Cliente eduardo = new Cliente(counter.incrementAndGet(), "Eduardo");
		Cliente zoe = new Cliente(counter.incrementAndGet(), "Zoe");
		Cliente vere = new Cliente(counter.incrementAndGet(), "Vere");
		
		List<Cliente> listClient = new ArrayList<>();
		listClient.add(eduardo);
		listClient.add(zoe);
		listClient.add(vere);
		
		System.out.println("::::::::::: Clientes :::::::::::");
		System.out.println(listClient);
		
		return listClient;
	}
	
	@RequestMapping(path="/cliente", method= RequestMethod.GET)
	@ResponseBody
	public String infoClientes(@RequestParam(name="op2", required=false, defaultValue="0") Integer param) {
		System.out.println("Envio por GET");
		System.out.println("Parametro: " + param);
		return "Envio de clientes exitoso";
	}
	
	
	@RequestMapping(path="/cliente", method=RequestMethod.POST)
	@ResponseBody
	public String guardarCliente(int idCliente, String nombre) {
		System.out.println("Guardar cliente por POST ");
		System.out.println("IdCliente: " + idCliente);
		System.out.println("Nombre:  " + nombre);
		return "Cliente guardado de forma exitosa";
	}
	
	@RequestMapping(path="/cliente", method=RequestMethod.PUT)
	@ResponseBody
	public String actualizarCliente(int idCliente, String nombre) {
		System.out.println(":::: Actualizar cliente por PUT");
		System.out.println("IdCliente: " + idCliente);
		System.out.println("Nombre:  " + nombre);
		return "Actualización de cliente de forma exitosa";
	}
	
	
	@RequestMapping(path="/cliente/{idEliminar}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteClientes(@PathVariable int idEliminar) {
		System.out.println("Envio por DELETE");
		System.out.println("IdEliminar: " + idEliminar);
		return "Elimnar Clientes de forma exitosa";
	}
}
