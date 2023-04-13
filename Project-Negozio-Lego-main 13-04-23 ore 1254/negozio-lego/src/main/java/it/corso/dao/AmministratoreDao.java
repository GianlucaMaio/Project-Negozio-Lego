package it.corso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Amministratore;

public interface AmministratoreDao extends CrudRepository<Amministratore, Integer> {

	//List<Amministratore> findByAmministratore(String username, String password);
}
