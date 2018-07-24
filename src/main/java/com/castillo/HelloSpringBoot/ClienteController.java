package com.castillo.HelloSpringBoot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.castillo.model.Persona;

//@RestController
//@RequestMapping("/cliente")
@Controller
public class ClienteController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(path = "/body")
	@ResponseBody
	public String body() {
		return "lista";
	}

	@RequestMapping(path = "/lista")
	public String estado(Model model) {
		model.addAttribute("nombre", "Lista de nombresssss");
		return "lista";
	}
	
	@RequestMapping(path="/persona/{id}")
	public String muestra(@PathVariable String id, Model model) {
		model.addAttribute("usuario", new Persona("persona " + id, "Selva"));
		return "persona";
	}
	
	@RequestMapping(path="/defecto")
	public void resolucionPorDefeco() {}
	
	
	@RequestMapping(path="/dir/defecto")
	public void subdirectorio() {}
	
	
	
	
	
	@RequestMapping(path = "/getClientes", produces= {MediaType.APPLICATION_XML_VALUE} )
	public List<Cliente> getClientes(){
		System.out.println(":::::::::: Inicio de ejecucion para solicitar clientes :::::::::");
		Cliente eduardo = new Cliente(counter.incrementAndGet(), "Eduardo", "Jilotepec");
		Cliente zoe = new Cliente(counter.incrementAndGet(), "Zoe", "Chapa Mota");
		Cliente vere = new Cliente(counter.incrementAndGet(), "Vere", "TImilpan");
		
		List<Cliente> listClient = new ArrayList<>();
		listClient.add(eduardo);
		listClient.add(zoe);
		listClient.add(vere);
		
		System.out.println("::::::::::: Clientes :::::::::::");
		System.out.println(listClient);
		
		return listClient;
	}
	
	@RequestMapping(path="/obtenerCliente", produces= {MediaType.APPLICATION_XML_VALUE}, method=RequestMethod.GET)
	public Cliente getCliente() {
		return new Cliente(counter.incrementAndGet(), "IamExpert in Spring", "Jilotepec");
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
