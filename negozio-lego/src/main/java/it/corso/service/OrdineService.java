package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;

public interface OrdineService {

	void registraOrdine(Ordine ordine, String data, int idCliente, int [] idProdotti);
	Ordine getOrdineById(int id);
	List<Ordine> geOrdine();
	void cancellaOrdine(Ordine ordine);
	
}
