package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Catalogo;
import it.corso.service.CatalogoService;
import it.corso.service.CategoriaService;

//localhost:8051/harrypotter
@Controller
@RequestMapping("/harrypotter")
public class HarryPotterController {

	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String getPage(Model model) {
		
		List<Catalogo> prodotto = catalogoService.getProdotti();
		model.addAttribute("prodotto", prodotto); 
		
		return "harrypotter";
	}
}
