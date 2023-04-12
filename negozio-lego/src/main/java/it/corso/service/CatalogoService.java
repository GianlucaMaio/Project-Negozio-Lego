package it.corso.service;

import java.util.List;

import it.corso.model.Catalogo;


public interface CatalogoService {

	void registraProdotto (Catalogo catalogo);
	Catalogo getProdottoById(int id);
	List<Catalogo> getProdotti();
	void cancellaProdotto(Catalogo catalogo);
	
}
