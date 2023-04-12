package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;

public class OrdineServiceImp implements OrdineService {

	//inserire autowired
	
	@Override
	public void registraOrdine(Ordine ordine, String data, int idCliente, int[] idProdotti) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ordine getOrdineById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordine> geOrdine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancellaOrdine(Ordine ordine) {
		// TODO Auto-generated method stub

	}

}
