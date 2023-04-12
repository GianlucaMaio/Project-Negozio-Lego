package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Catalogo;

public interface CataologoDao extends CrudRepository<Catalogo, Integer> {

}
