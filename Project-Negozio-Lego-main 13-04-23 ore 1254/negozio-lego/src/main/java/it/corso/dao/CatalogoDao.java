package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Catalogo;

public interface CatalogoDao extends CrudRepository<Catalogo, Integer> {

}
