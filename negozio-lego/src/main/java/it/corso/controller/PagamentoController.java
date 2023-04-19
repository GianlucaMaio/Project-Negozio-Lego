package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Catalogo;
import it.corso.model.Cliente;
import it.corso.service.ClienteService;
import jakarta.servlet.http.HttpSession;

//localhost:8051/pagamento
@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private ClienteService clienteService;
	
/*	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(HttpSession session, Model model) {
		
		List<Catalogo> carrello = session.getAttribute("carrello") == null ? new ArrayList<>() : (List<Catalogo>) session.getAttribute("carrello");
		double totale = carrello.stream().mapToDouble(p->p.getPrezzo()).reduce(0, (p1,p2)->p1+p2);
		model.addAttribute("totale", totale);
		model.addAttribute("carrello", carrello);
		
		return "pagamento";
	}*/
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(HttpSession session, Model model,
			@PathVariable int id, 
    		@RequestParam("indirizzo") String indirizzo,
    		@RequestParam("localita") String localita,
    		@RequestParam("provincia") String provincia,
    		@RequestParam("cap") String cap
			) {
		
		List<Catalogo> carrello = session.getAttribute("carrello") == null ? new ArrayList<>() : (List<Catalogo>) session.getAttribute("carrello");
		double totale = carrello.stream().mapToDouble(p->p.getPrezzo()).reduce(0, (p1,p2)->p1+p2);
		model.addAttribute("totale", totale);
		model.addAttribute("carrello", carrello);
		
		 Cliente cliente = clienteService.getClienteById(id);
		 cliente.getIndirizzo();
		 
		 model.addAttribute("cliente", cliente);
		return "pagamento";
	}
/*	 @GetMapping
	    public String getCliente(@PathVariable int id, 
	    		@RequestParam("indirizzo") String indirizzo,
	    		@RequestParam("localita") String localita,
	    		@RequestParam("provincia") String provincia,
	    		@RequestParam("cap") String cap, 
	    		Model model,
	    		HttpSession session
	    		) {
		 
		 Cliente cliente = clienteService.getClienteById(id);
		 cliente.getIndirizzo();
		 
		 model.addAttribute("cliente", cliente);
		 
	        return "pagamento";
	        
	    }*/
}
