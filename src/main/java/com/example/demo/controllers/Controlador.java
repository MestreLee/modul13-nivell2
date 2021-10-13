package com.example.demo.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Empleat;
import com.example.demo.beans.Feina;
import com.example.demo.repository.BaseDades;

@Controller 
@RequestMapping("")
public class Controlador {
	
	BaseDades bd = new BaseDades();

	Empleat empleat;
	
	@GetMapping("/")
	public String login(Model model) {
			ArrayList<Empleat> empleats = bd.getEmpleats();
			model.addAttribute("empleats", empleats);
			model.addAttribute("empleat", new Empleat());
			model.addAttribute("feines", Feina.values());
			model.addAttribute("boto", "Inserta Empleat");
			model.addAttribute("action", "/insertar");
			model.addAttribute("boto2", "Busca per feina");
			model.addAttribute("action2", "/buscar");
			return "empleats";

	}
	
	@PostMapping("/insertar")
	public String insertar(Empleat empleat, Model model) {
			bd.insertar(empleat);
			ArrayList<Empleat> empleats = bd.getEmpleats();
			model.addAttribute("empleats", empleats);
			model.addAttribute("boto", "Inserta Empleat");
			model.addAttribute("action", "/insertar");
			model.addAttribute("boto2", "Busca per feina");
			model.addAttribute("action2", "/buscar");
			model.addAttribute("empleat", new Empleat());
			model.addAttribute("feines", Feina.values());
			return "empleats";	
	}
	@PostMapping("/buscar")
	public String buscar(Feina feina, Model model) {
			ArrayList<Empleat> empleats = bd.buscar(feina);
			model.addAttribute("empleats", empleats);
			model.addAttribute("boto", "Inserta Empleat");
			model.addAttribute("action", "/insertar");
			model.addAttribute("boto2", "Busca per feina");
			model.addAttribute("action2", "/buscar");
			model.addAttribute("empleat", new Empleat());
			model.addAttribute("feines", Feina.values());
			return "empleats";	
	}
	
	/*@PostMapping("/buscar")
	public String buscar2(int id, Model model) {
		    ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		    Empleat empleat = bd.getEmpleat(id);
		    empleats.add(empleat);
			model.addAttribute("empleats", empleats);
			model.addAttribute("boto", "Inserta Empleat");
			model.addAttribute("action", "/insertar");
			model.addAttribute("boto2", "Busca per feina");
			model.addAttribute("action2", "/buscar");
			model.addAttribute("empleat", new Empleat());
			model.addAttribute("feines", Feina.values());
			return "empleats";	
	}*/
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", new Empleat());
		model.addAttribute("feines", Feina.values());
		model.addAttribute("boto", "Inserta Empleat");
		model.addAttribute("action", "/insertar");	
		model.addAttribute("boto2", "Busca per feina");
		model.addAttribute("action2", "/buscar");
		return "empleats";
	}
	
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Empleat empleat = bd.getEmpleat(id);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", empleat);
		model.addAttribute("feines", Feina.values());
		model.addAttribute("boto", "Actualitza Empleat");
		model.addAttribute("action", "/modificar");	
		model.addAttribute("boto2", "Busca per feina");
		model.addAttribute("action2", "/buscar");
		return "empleats";
	}
	
	@PostMapping("/modificar")
	public String modificar2(Empleat empleat, Model model) {
		bd.modificar(empleat);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("boto", "Inserta Empleat");
		model.addAttribute("action", "/insertar");	
		model.addAttribute("boto2", "Busca per feina");
		model.addAttribute("action2", "/buscar");
		model.addAttribute("empleat", new Empleat());
		model.addAttribute("feines", Feina.values());
		return "empleats";
	}

}
