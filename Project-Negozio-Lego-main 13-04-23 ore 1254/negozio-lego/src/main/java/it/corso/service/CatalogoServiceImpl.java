package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.CatalogoDao;
import it.corso.model.Catalogo;

public class CatalogoServiceImpl implements CatalogoService {

	//inserire autowired
	@Autowired
	private CatalogoDao catalogoDao;
	
	@Override
	public void registraProdotto(Catalogo catalogo) {
		catalogoDao.save(catalogo);

	}

	@Override
	public Catalogo getProdottoById(int id) {
		// TODO Auto-generated method stub
		return catalogoDao.findById(id).get();
	}

	@Override
	public List<Catalogo> getProdotti() {
		// TODO Auto-generated method stub
		return (List<Catalogo>) catalogoDao.findAll();
	}

	@Override
	public void cancellaProdotto(Catalogo catalogo) {
		// TODO Auto-generated method stub
		catalogoDao.delete(catalogo);

	}

}
